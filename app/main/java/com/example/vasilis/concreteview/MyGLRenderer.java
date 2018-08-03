package com.example.vasilis.concreteview;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import com.example.vasilis.concreteview.tools.Concrete;
import com.example.vasilis.concreteview.tools.Cylinder;
import com.example.vasilis.concreteview.tools.RawResourceReader;
import com.example.vasilis.concreteview.tools.ShaderHelper;
import com.example.vasilis.concreteview.tools.Steel;
import com.example.vasilis.concreteview.tools.SteelModel;
import com.example.vasilis.concreteview.tools.TextureHelper;
import com.example.vasilis.concreteview.tools.Torus;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MyGLRenderer implements GLSurfaceView.Renderer {

    private final MainActivity mActivity;
    private final MyGLSurfaceView myGLSurfaceView;



   // private final FloatBuffer mTorusPositions;
   // private final FloatBuffer mTorusColors;
   // private final FloatBuffer mTorusNormals;

    private int mSteelPositionsIdx;
    private int mSteelColorsIdx;
    private int mSteelNormalsIdx;
    private int mSteelTextureCoordinatesIdx;

    private int mConcretePositionsIdx;
    private int mConcreteColorsIdx;
    private int mConcreteNormalsIdx;
    private int mConcreteTextureCoordinatesIdx;

    private int mCylinderPositionsIdx;
    private int mCylinderColorsIdx;
    private int mCylinderNormalsIdx;
    private int mCylinderTextureCoordinatesIdx;


    private float[] mViewMatrix=new float[16];
    private float[] mProjectionMatrix=new float[16];
    private float[] mModelMatrix=new float[16];
    private float[] mMVPMatrix=new float[16];
    private final float[] mAccumulatedRotation = new float[16];
    private final float[] mCurrentRotation = new float[16];
    private final float[] mScaleMatrix=new float[16];
    private float[] mTemporaryMatrix = new float[16];
    private float[] mLightModelMatrix=new float[16];


    private int mMVPMatrixHandle;
    private int mMVMatrixHandle;
    private int mLightPosHandle;
    private int mTextureUniformHandle;
    private int mColorHandle;
    private int mPositionHandle;
    private int mNormalHandle;
    private int mTextureCoordinateHandle;

    private int SteelModelVertices;
    private int ConcreteVertices;


    private final int mBytesPerFloat = 4;


    private final int BYTES_PER_FLOAT = 4;
    private final int POSITION_DATA_SIZE = 3;
    private final int NORMAL_DATA_SIZE = 3;
    private final int COLOR_DATA_SIZE=4;
    static final int TEXTURE_COORDINATE_DATA_SIZE = 2;

    /** Used to hold a light centered on the origin in model space. We need a 4th coordinate so we can get translations to work when
     *  we multiply this by our transformation matrices. */
    private final float[] mLightPosInModelSpace = new float[] {0.0f, 0.0f, 0.0f, 1.0f};

    /** Used to hold the current position of the light in world space (after transformation via model matrix). */
    private final float[] mLightPosInWorldSpace = new float[4];

    /** Used to hold the transformed position of the light in eye space (after transformation via modelview matrix) */
    private final float[] mLightPosInEyeSpace = new float[4];

    private int mProgramHandle;
    private int mSteelDataHandle;
    private int mConcreteDataHandle;


    public volatile float mDeltaX;
    public volatile float mDeltaY;
    public volatile float mScale;
    public volatile boolean persp=false;

    private float ratio;

    //private Torus mTorus;




    public MyGLRenderer(final MainActivity mActivity1,final MyGLSurfaceView myGLSurfaceView1){
        mActivity=mActivity1;
        myGLSurfaceView=myGLSurfaceView1;




    }

    private void generateData(){
        SteelModel mSteelModel;
        Concrete mConcrete;


        float L=2.6f;
        float dL2=0.1f;
        float dL=2*dL2;
        float B=0.4f;
        float dB2=0.05f;
        float dB=2*dB2;
        float H=0.7f;
        float dH2=0.05f;
        float dH=2*dH2;
        int nUp=3;
        float Rup=0.014f;
        int nDown=4;
        float RDown=0.016f;
        int nShearSteels=10;

        float x[]=new float[nShearSteels];
        for(int i=0; i<nShearSteels;i++){
            x[i]=((i+0.5f)*1.0f)/(nShearSteels*1.0f);
        }
        float r=0.008f;
        float R=(float)(Math.max(RDown,Rup));







        FloatBuffer mSteelModelPositions;
        FloatBuffer mSteelModelColors;
        FloatBuffer mSteelModelNormals;
        FloatBuffer mSteelModelTextureCoordinates;

        mSteelModel=new SteelModel(L, B, H, nUp, Rup, nDown, RDown, r, R, x);

        mSteelModelPositions= ByteBuffer.allocateDirect(mSteelModel.SteelModelVertices.length*BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mSteelModelPositions.put(mSteelModel.SteelModelVertices).position(0);

        mSteelModelColors=ByteBuffer.allocateDirect(mSteelModel.SteelModelColors.length*BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mSteelModelColors.put(mSteelModel.SteelModelColors).position(0);

        mSteelModelTextureCoordinates=ByteBuffer.allocateDirect(mSteelModel.SteelModelTextureCoordinates.length*BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mSteelModelTextureCoordinates.put(mSteelModel.SteelModelTextureCoordinates).position(0);

        mSteelModelNormals=ByteBuffer.allocateDirect(mSteelModel.SteelModelNormals.length*BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mSteelModelNormals.put(mSteelModel.SteelModelNormals).position(0);

        final int SteelModelBuffers[] = new int[4];
        GLES20.glGenBuffers(4, SteelModelBuffers, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, SteelModelBuffers[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, mSteelModelPositions.capacity() * BYTES_PER_FLOAT, mSteelModelPositions, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, SteelModelBuffers[1]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, mSteelModelColors.capacity() * BYTES_PER_FLOAT, mSteelModelColors, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, SteelModelBuffers[2]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, mSteelModelTextureCoordinates.capacity() * BYTES_PER_FLOAT, mSteelModelTextureCoordinates,
                GLES20.GL_STATIC_DRAW);
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, SteelModelBuffers[3]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER,  mSteelModelNormals.capacity() * BYTES_PER_FLOAT,  mSteelModelNormals,
                GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);


        mSteelPositionsIdx=SteelModelBuffers[0];
        mSteelColorsIdx=SteelModelBuffers[1];
        mSteelTextureCoordinatesIdx=SteelModelBuffers[2];
        mSteelNormalsIdx=SteelModelBuffers[3];
        SteelModelVertices=mSteelModel.nVertices;

        mSteelModelPositions.limit(0);
        mSteelModelPositions=null;
        mSteelModelColors.limit(0);
        mSteelModelColors=null;
        mSteelModelNormals.limit(0);
        mSteelModelNormals=null;
        mSteelModelTextureCoordinates.limit(0);
        mSteelModelTextureCoordinates=null;
        mSteelModel=null;









        FloatBuffer mConcretePositions;
        FloatBuffer mConcreteColors;
        FloatBuffer mConcreteNormals;
        FloatBuffer mConcreteTextureCoordinates;


        mConcrete=new Concrete(B+dB,L+dL,H+dH,0.05f,0.6f);
        mConcretePositions= ByteBuffer.allocateDirect(mConcrete.ConcreteVertices.length*mBytesPerFloat).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mConcretePositions.put(mConcrete.ConcreteVertices).position(0);

        mConcreteColors=ByteBuffer.allocateDirect(mConcrete.ConcreteColors.length*mBytesPerFloat).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mConcreteColors.put(mConcrete.ConcreteColors).position(0);

        mConcreteTextureCoordinates=ByteBuffer.allocateDirect(mConcrete.ConcreteTextureCoordinates.length*mBytesPerFloat).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mConcreteTextureCoordinates.put(mConcrete.ConcreteTextureCoordinates).position(0);

        mConcreteNormals=ByteBuffer.allocateDirect(mConcrete.ConcreteNormals.length*mBytesPerFloat).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mConcreteNormals.put(mConcrete.ConcreteNormals).position(0);


        final int ConcreteBuffers[] = new int[4];
        GLES20.glGenBuffers(4, ConcreteBuffers, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, ConcreteBuffers[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, mConcretePositions.capacity() * BYTES_PER_FLOAT, mConcretePositions, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, ConcreteBuffers[1]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, mConcreteColors.capacity() * BYTES_PER_FLOAT, mConcreteColors, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, ConcreteBuffers[2]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, mConcreteTextureCoordinates.capacity() * BYTES_PER_FLOAT, mConcreteTextureCoordinates,
                GLES20.GL_STATIC_DRAW);
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, ConcreteBuffers[3]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER,  mConcreteNormals.capacity() * BYTES_PER_FLOAT,  mConcreteNormals,
                GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);



        mConcretePositionsIdx=ConcreteBuffers[0];
        mConcreteColorsIdx=ConcreteBuffers[1];
        mConcreteTextureCoordinatesIdx=ConcreteBuffers[2];
        mConcreteNormalsIdx=ConcreteBuffers[3];
        ConcreteVertices=mConcrete.nVertices;

        mConcretePositions.limit(0);
        mConcretePositions=null;
        mConcreteColors.limit(0);
        mConcreteColors=null;
        mConcreteNormals.limit(0);
        mConcreteNormals=null;
        mConcreteTextureCoordinates.limit(0);
        mConcreteTextureCoordinates=null;
        mConcrete=null;
















    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f,0.0f,0.0f,0.0f);
        mScale=0.5f;
        generateData();
        // Depth testing and Face culling
        GLES20.glEnable(GLES20.GL_CULL_FACE);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        // Enable blending
        //GLES20.glDisable(GLES20.GL_CULL_FACE);
        GLES20.glEnable(GLES20.GL_BLEND);
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);



        //Position the eye behind the origin
        final float eyeX=-2.5f;
        final float eyeY=0.0f;
        final float eyeZ=0.0f;

        //We are looking toward the distance
        final float lookX=1.0f;
        final float lookY=0.0f;
        final float lookZ=0.0f;

        //Set our up vector. This is where our head would be pointing were we holding the camera
        final float upX=0.0f;
        final float upY=0.0f;
        final float upZ=1.0f;

        //Set the view matrix. This matrix can be said to represent the camera position.
        //Note: In OpenGL 1, a ModelView matrix is used, which is a combination of a model and
        //view matrix. In OpenGL 2, we can keep track of these matrices separately if we choose.

        Matrix.setLookAtM(mViewMatrix, 0, eyeX, eyeY, eyeZ, lookX, lookY, lookZ, upX, upY, upZ);


        final String vertexShader = RawResourceReader.readTextFileFromRawResource(mActivity, R.raw.per_pixel_vertex_shader);
        final String fragmentShader = RawResourceReader.readTextFileFromRawResource(mActivity, R.raw.per_pixel_fragment_shader);

        int vertexShaderHandle= ShaderHelper.compileShader(GLES20.GL_VERTEX_SHADER, vertexShader);
        int fragmentShaderHandle= ShaderHelper.compileShader(GLES20.GL_FRAGMENT_SHADER, fragmentShader);

        mProgramHandle = ShaderHelper.createAndLinkProgram(vertexShaderHandle, fragmentShaderHandle, new String[] {"a_Position",  "a_Normal", "a_TexCoordinate"});


        // Load the Steel texture
        mSteelDataHandle = TextureHelper.loadTexture(mActivity, R.drawable.steel3);
        GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mSteelDataHandle);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mSteelDataHandle);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR_MIPMAP_LINEAR);

        // Load the Concrete texture
        mConcreteDataHandle = TextureHelper.loadTexture(mActivity, R.drawable.concrete2);
        GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mConcreteDataHandle);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mConcreteDataHandle);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR_MIPMAP_LINEAR);

        // Initialize the accumulated rotation matrix
        Matrix.setIdentityM(mAccumulatedRotation, 0);


    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0,0,width,height);
        ratio =(float)width/height;




    }

    @Override
    public void onDrawFrame(GL10 gl) {

        final float left=-ratio;
        final float right=ratio;
        final float bottom=-1.0f;
        final float top=1.0f;
        final float near=1.0f;
        final float far=10.0f;

        if(persp){
            Matrix.frustumM(mProjectionMatrix,0 ,left,right,bottom,top,near,far);
        }else{
            Matrix.orthoM(mProjectionMatrix,0 ,left,right,bottom,top,near,far);
        }

        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);

        GLES20.glUseProgram(mProgramHandle);


        // Set program handles for drawing.
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_MVPMatrix");
        mMVMatrixHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_MVMatrix");
        mLightPosHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_LightPos");
        mTextureUniformHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_Texture");
        mPositionHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Position");
        mColorHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Color");
        mNormalHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Normal");
        mTextureCoordinateHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_TexCoordinate");

        // Calculate position of the light. Push into the distance.
        Matrix.setIdentityM(mLightModelMatrix, 0);
        Matrix.translateM(mLightModelMatrix, 0, -40.5f, 0.5f, 0.5f);

        Matrix.multiplyMV(mLightPosInWorldSpace, 0, mLightModelMatrix, 0, mLightPosInModelSpace, 0);
        Matrix.multiplyMV(mLightPosInEyeSpace, 0, mViewMatrix, 0, mLightPosInWorldSpace, 0);

        Matrix.setIdentityM(mModelMatrix, 0);
        Matrix.translateM(mModelMatrix, 0, 1.0f, 0.0f, 0.0f);



        // Set a matrix that contains the current rotation.
        Matrix.setIdentityM(mCurrentRotation, 0);
        Matrix.rotateM(mCurrentRotation, 0, mDeltaX, 0.0f,  0.0f, 1.0f);
        Matrix.rotateM(mCurrentRotation, 0, mDeltaY, 0.0f, -1.0f, 0.0f);
        mDeltaX = 0.0f;
        mDeltaY = 0.0f;

        /*Set a matrix that contains the scale transformation*/
        Matrix.setIdentityM(mScaleMatrix, 0);
        Matrix.scaleM(mScaleMatrix, 0, mScale, mScale, mScale);


        // Multiply the current rotation by the accumulated rotation, and then set the accumulated rotation to the result.
        Matrix.multiplyMM(mTemporaryMatrix, 0, mCurrentRotation, 0, mAccumulatedRotation, 0);
        System.arraycopy(mTemporaryMatrix, 0, mAccumulatedRotation, 0, 16);

        // Rotate taking the overall rotation into account.
        Matrix.multiplyMM(mTemporaryMatrix, 0, mModelMatrix, 0, mAccumulatedRotation, 0);
        System.arraycopy(mTemporaryMatrix, 0, mModelMatrix, 0, 16);

        //Scale the model
        Matrix.multiplyMM(mTemporaryMatrix, 0, mModelMatrix, 0, mScaleMatrix, 0);
        System.arraycopy(mTemporaryMatrix, 0, mModelMatrix, 0, 16);

        // This multiplies the view matrix by the model matrix, and stores
        // the result in the MVP matrix
        // (which currently contains model * view).
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0);

        // Pass in the modelview matrix.
        GLES20.glUniformMatrix4fv(mMVMatrixHandle, 1, false, mMVPMatrix, 0);

        // This multiplies the modelview matrix by the projection matrix,
        // and stores the result in the MVP matrix
        // (which now contains model * view * projection).
        Matrix.multiplyMM(mTemporaryMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0);
        System.arraycopy(mTemporaryMatrix, 0, mMVPMatrix, 0, 16);

        // Pass in the combined matrix.
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);

        // Pass in the light position in eye space.
        GLES20.glUniform3f(mLightPosHandle, mLightPosInEyeSpace[0], mLightPosInEyeSpace[1], mLightPosInEyeSpace[2]);






        //drawTorus();
        //drawSteel();
        //drawCylinder();
        drawSteelModel();
        drawConcrete();



    }


    private void drawSteelModel(){

        // Pass in the texture information
        // Set the active texture unit to texture unit 0.
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);

        // Bind the texture to this unit.
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mSteelDataHandle);

        // Tell the texture uniform sampler to use this texture in the
        // shader by binding to texture unit 0.
        GLES20.glUniform1i(mTextureUniformHandle, 0);


        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mSteelPositionsIdx);
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        GLES20.glVertexAttribPointer(mPositionHandle,POSITION_DATA_SIZE, GLES20.GL_FLOAT,false, 0, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mSteelColorsIdx);
        GLES20.glEnableVertexAttribArray(mColorHandle);
        GLES20.glVertexAttribPointer(mColorHandle,COLOR_DATA_SIZE,GLES20.GL_FLOAT,false,0, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mSteelNormalsIdx);
        GLES20.glEnableVertexAttribArray(mNormalHandle);
        GLES20.glVertexAttribPointer(mNormalHandle,NORMAL_DATA_SIZE,GLES20.GL_FLOAT,false,0, 0);



        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mSteelTextureCoordinatesIdx);
        GLES20.glEnableVertexAttribArray(mTextureCoordinateHandle);
        GLES20.glVertexAttribPointer(mTextureCoordinateHandle, TEXTURE_COORDINATE_DATA_SIZE, GLES20.GL_FLOAT, false, 0, 0);

        // Clear the currently bound buffer (so future OpenGL calls do not use this buffer).
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);


        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, SteelModelVertices);



    }
    private void drawConcrete(){

        // Pass in the texture information
        // Set the active texture unit to texture unit 0.
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);

        // Bind the texture to this unit.
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mConcreteDataHandle);

        // Tell the texture uniform sampler to use this texture in the
        // shader by binding to texture unit 0.
        GLES20.glUniform1i(mTextureUniformHandle, 0);


        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mConcretePositionsIdx);
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        GLES20.glVertexAttribPointer(mPositionHandle, POSITION_DATA_SIZE, GLES20.GL_FLOAT, false, 0, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mConcreteNormalsIdx);
        GLES20.glEnableVertexAttribArray(mNormalHandle);
        GLES20.glVertexAttribPointer(mNormalHandle, NORMAL_DATA_SIZE, GLES20.GL_FLOAT, false, 0, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mConcreteColorsIdx);
        GLES20.glEnableVertexAttribArray(mColorHandle);
        GLES20.glVertexAttribPointer(mColorHandle, COLOR_DATA_SIZE, GLES20.GL_FLOAT, false, 0, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mConcreteTextureCoordinatesIdx);
        GLES20.glEnableVertexAttribArray(mTextureCoordinateHandle);
        GLES20.glVertexAttribPointer(mTextureCoordinateHandle, TEXTURE_COORDINATE_DATA_SIZE, GLES20.GL_FLOAT, false, 0, 0);

        // Clear the currently bound buffer (so future OpenGL calls do not use this buffer).
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);


        GLES20.glDrawArrays(GLES20.GL_TRIANGLES,0,ConcreteVertices);



    }

}
