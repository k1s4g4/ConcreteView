package com.example.vasilis.concreteview.tools;



public class Cylinder {
    public float[] CylinderVertices;
    public float[] CylinderNormals;
    public float[] CylinderColors;
    public float[] CylinderTextureCoordinates;
    public int nVertices;
    public Cylinder(int Ni,float length,float r,float dy,float dz){

        nVertices = Ni*12;
        CylinderVertices = new float[ Ni * 36];
        CylinderNormals = new float[Ni*36];
        CylinderColors = new float[Ni * 48];
        CylinderTextureCoordinates=new float[Ni*24];
        double deltaI = 2 * Math.PI / Ni;


        for(int i=0; i<Ni; i++){
            double iangle = i * deltaI, iiangle = (i + 1) * deltaI;
            double cosi = Math.cos(iangle), cosii = Math.cos(iiangle);
            double sini = Math.sin(iangle), sinii = Math.sin(iiangle);

            int index = 36*i;


            //  CYLINDER VERTICES

            //TRIANGLE 1
            //Vertex 1
            CylinderVertices[index + 0] =  -length/2;
            CylinderVertices[index + 1] = (float) (0+dy);
            CylinderVertices[index + 2] = (float) (0+dz);
            //Vertex 2
            CylinderVertices[index + 3] =  -length/2;
            CylinderVertices[index + 4] = (float) (r*sini+dy);
            CylinderVertices[index + 5] = (float) (r*cosi+dz);
            //Vertex 3
            CylinderVertices[index + 6] =  -length/2;
            CylinderVertices[index + 7] = (float) (r*sinii+dy);
            CylinderVertices[index + 8] = (float) (r*cosii+dz);

            //TRIANGLE 2
            //Vertex 1
            CylinderVertices[index + 9] =  -length/2;
            CylinderVertices[index + 10] = (float) (r*sini+dy);
            CylinderVertices[index + 11] = (float) (r*cosi+dz);
            //Vertex 2
            CylinderVertices[index + 12] = length/2;
            CylinderVertices[index + 13] = (float) (r*sini+dy);
            CylinderVertices[index + 14] = (float) (r*cosi+dz);
            //Vertex 3
            CylinderVertices[index + 15] =  -length/2;
            CylinderVertices[index + 16] = (float) (r*sinii+dy);
            CylinderVertices[index + 17] = (float) (r*cosii+dz);

            //TRIANGLE 3
            //Vertex 1
            CylinderVertices[index + 18] =  -length/2;
            CylinderVertices[index + 19] = (float) (r*sinii+dy);
            CylinderVertices[index + 20] = (float) (r*cosii+dz);
            //Vertex 2
            CylinderVertices[index + 21] =  length/2;
            CylinderVertices[index + 22] = (float) (r*sini+dy);
            CylinderVertices[index + 23] = (float) (r*cosi+dz);
            //Vertex 3
            CylinderVertices[index + 24] =  length/2;
            CylinderVertices[index + 25] = (float) (r*sinii+dy);
            CylinderVertices[index + 26] = (float) (r*cosii+dz);


            //TRIANGLE 4
            //Vertex 1
            CylinderVertices[index + 27] =  length/2;
            CylinderVertices[index + 28] = (float) (r*sinii+dy);
            CylinderVertices[index + 29] = (float) (r*cosii+dz);
            //Vertex 2
            CylinderVertices[index + 30] =  length/2;
            CylinderVertices[index + 31] = (float) (r*sini+dy);
            CylinderVertices[index + 32] = (float) (r*cosi+dz);
            //Vertex 3
            CylinderVertices[index + 33] =  length/2;
            CylinderVertices[index + 34] = (float) (0+dy);
            CylinderVertices[index + 35] = (float) (0+dz);







            //  CYLINDER NORMALS

            //TRIANGLE 1
            //Vertex 1
            CylinderNormals[index + 0] = -1.0f;
            CylinderNormals[index + 1] = 0.0f;
            CylinderNormals[index + 2] = 0.0f;
            //Vertex 2
            CylinderNormals[index + 3] =  -1.0f;
            CylinderNormals[index + 4] = 0.0f;
            CylinderNormals[index + 5] = 0.0f;
            //Vertex 3
            CylinderNormals[index + 6] = -1.0f ;
            CylinderNormals[index + 7] =  0.0f;
            CylinderNormals[index + 8] = 0.0f;

            //TRIANGLE 2
            //Vertex 1
            CylinderNormals[index + 9] =  0.0f;
            CylinderNormals[index + 10] = (float) (sini);
            CylinderNormals[index + 11] = (float) (cosi);
            //Vertex 2
            CylinderNormals[index + 12] = 0.0f;
            CylinderNormals[index + 13] = (float) (sini);
            CylinderNormals[index + 14] = (float) (cosi);
            //Vertex 3
            CylinderNormals[index + 15] = 0.0f ;
            CylinderNormals[index + 16] = (float) (sinii);
            CylinderNormals[index + 17] = (float) (cosii);

            //TRIANGLE 3
            //Vertex 1
            CylinderNormals[index + 18] = 0.0f;
            CylinderNormals[index + 19] = (float) (sinii);
            CylinderNormals[index + 20] = (float) (cosii);
            //Vertex 2
            CylinderNormals[index + 21] =  0.0f;
            CylinderNormals[index + 22] = (float) (sini);
            CylinderNormals[index + 23] = (float) (cosi);
            //Vertex 3
            CylinderNormals[index + 24] =  0.0f;
            CylinderNormals[index + 25] = (float) (sinii);
            CylinderNormals[index + 26] = (float) (cosii);


            //TRIANGLE 4
            //Vertex 1
            CylinderNormals[index + 27] =  1.0f;
            CylinderNormals[index + 28] = 0.0f;
            CylinderNormals[index + 29] = 0.0f;
            //Vertex 2
            CylinderNormals[index + 30] = 1.0f;
            CylinderNormals[index + 31] = 0.0f;
            CylinderNormals[index + 32] = 0.0f;
            //Vertex 3
            CylinderNormals[index + 33] =  1.0f;
            CylinderNormals[index + 34] = 0.0f;
            CylinderNormals[index + 35] = 0.0f;






            //  CYLINDER COLORS

            index=i*48;
            //TRIANGLE 1
            //Vertex 1
            CylinderColors[index + 0] = 0.5f;
            CylinderColors[index + 1] = 0.5f;
            CylinderColors[index + 2] = 0.5f;
            CylinderColors[index + 3] = 1.0f;
            //Vertex 2
            CylinderColors[index + 4] = 0.5f;
            CylinderColors[index + 5] = 0.5f;
            CylinderColors[index + 6] = 0.5f;
            CylinderColors[index + 7] = 1.0f;
            //Vertex 3
            CylinderColors[index + 8] = 0.5f;
            CylinderColors[index + 9] = 0.5f;
            CylinderColors[index + 10] = 0.5f;
            CylinderColors[index + 11] = 1.0f;
            //TRIANGLE 2
            //Vertex 1
            CylinderColors[index + 12] = 0.5f;
            CylinderColors[index + 13] = 0.5f;
            CylinderColors[index + 14] = 0.5f;
            CylinderColors[index + 15] = 1.0f;
            //Vertex 2
            CylinderColors[index + 16] = 0.5f;
            CylinderColors[index + 17] = 0.5f;
            CylinderColors[index + 18] = 0.5f;
            CylinderColors[index + 19] = 1.0f;
            //Vertex 3
            CylinderColors[index + 20] = 0.5f;
            CylinderColors[index + 21] = 0.5f;
            CylinderColors[index + 22] = 0.5f;
            CylinderColors[index + 23] = 1.0f;

            //TRIANGLE 3
            //Vertex 1
            CylinderColors[index + 24] = 0.5f;
            CylinderColors[index + 25] = 0.5f;
            CylinderColors[index + 26] = 0.5f;
            CylinderColors[index + 27] = 1.0f;
            //Vertex 2
            CylinderColors[index + 28] = 0.5f;
            CylinderColors[index + 29] = 0.5f;
            CylinderColors[index + 30] = 0.5f;
            CylinderColors[index + 31] = 1.0f;
            //Vertex 3
            CylinderColors[index + 32] = 0.5f;
            CylinderColors[index + 33] = 0.5f;
            CylinderColors[index + 34] = 0.5f;
            CylinderColors[index + 35] = 1.0f;


            //TRIANGLE 4
            //Vertex 1
            CylinderColors[index + 36] = 0.5f;
            CylinderColors[index + 37] = 0.5f;
            CylinderColors[index + 38] = 0.5f;
            CylinderColors[index + 39] = 1.0f;
            //Vertex 2
            CylinderColors[index + 40] = 0.5f;
            CylinderColors[index + 41] = 0.5f;
            CylinderColors[index + 42] = 0.5f;
            CylinderColors[index + 43] = 1.0f;
            //Vertex 3
            CylinderColors[index + 44] = 0.5f;
            CylinderColors[index + 45] = 0.5f;
            CylinderColors[index + 46] = 0.5f;
            CylinderColors[index + 47] = 1.0f;


            //  CYLINDER TEXTURE COORDINATES

            index=i*24;
            float xScale=length/(2*dz);
            float yScale=1;
            //TRIANGLE 1
            //Vertex 1
            CylinderTextureCoordinates[index+0]=0.5f;
            CylinderTextureCoordinates[index+1]=0.5f;
            //Vertex 2
            CylinderTextureCoordinates[index+2]=(float)(0.5+0.03*sini);
            CylinderTextureCoordinates[index+3]=(float)(0.5+0.03*cosi);
            //Vertex 3
            CylinderTextureCoordinates[index+4]=(float)(0.5+0.03*sinii);
            CylinderTextureCoordinates[index+5]=(float)(0.5+0.03*cosii);

            //TRIANGLE 2
            //Vertex 1
            CylinderTextureCoordinates[index+6]=0 ;
            CylinderTextureCoordinates[index+7]=(float)(yScale*iangle/(2*Math.PI));
            //Vertex 2
            CylinderTextureCoordinates[index+8]=xScale;
            CylinderTextureCoordinates[index+9]=(float)(yScale*iangle/(2*Math.PI));
            //Vertex 3
            CylinderTextureCoordinates[index+10]=0;
            CylinderTextureCoordinates[index+11]=(float)(yScale*iiangle/(2*Math.PI));

            //TRIANGLE 3
            //Vertex 1
            CylinderTextureCoordinates[index+12]=0;
            CylinderTextureCoordinates[index+13]=(float)(yScale*iiangle/(2*Math.PI));
            //Vertex 2
            CylinderTextureCoordinates[index+14]=xScale;
            CylinderTextureCoordinates[index+15]=(float)(yScale*iangle/(2*Math.PI));
            //Vertex 3
            CylinderTextureCoordinates[index+16]=xScale;
            CylinderTextureCoordinates[index+17]=(float)(yScale*iiangle/(2*Math.PI));

            //TRIANGLE 4
            //Vertex 1
            CylinderTextureCoordinates[index+18]=(float)(0.5+0.03*sinii);
            CylinderTextureCoordinates[index+19]=(float)(0.5+0.03*cosii);
            //Vertex 2
            CylinderTextureCoordinates[index+20]=(float)(0.5+0.03*sini);
            CylinderTextureCoordinates[index+21]=(float)(0.5+0.03*cosi);
            //Vertex 3
            CylinderTextureCoordinates[index+22]=0.5f;
            CylinderTextureCoordinates[index+23]=0.5f;


        }
    }
}
