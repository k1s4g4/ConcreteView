package com.example.vasilis.concreteview.tools;


import java.nio.FloatBuffer;

public class SteelModel {
    public float[] SteelModelVertices;
    public float[] SteelModelColors;
    public float[] SteelModelNormals;
    public float[] SteelModelTextureCoordinates;
    public int nVertices;


    public SteelModel(float L,float B,float H,int nUp,float Rup,int nDown,float RDown,float r,float R,float x[]){
        TopRaw myTopRaw=new TopRaw(nUp, Rup, B-2*R-2*r, H-2*R-2*r, L);
        BottomRaw myBottomRaw=new BottomRaw(nDown, RDown, B-2*R-2*r, H-2*R-2*r, L);
        ShearSteel myShearSteel=new ShearSteel(B, H, L, x, R, r);



        nVertices=myTopRaw.nVertices+myBottomRaw.nVertices+myShearSteel.nVertices;
        SteelModelVertices=new float[nVertices*3];
        SteelModelColors=new float[nVertices*4];
        SteelModelNormals=new float[nVertices*3];
        SteelModelTextureCoordinates=new float[nVertices*2];


        int index=0;
        for(int i=0; i< myTopRaw.nVertices*3; i++){
            SteelModelVertices[index+i]=myTopRaw.UpRawVertices[i];
            SteelModelNormals[index+i]=myTopRaw.UpRawNormals[i];
        }
        for(int i=0; i< myTopRaw.nVertices*4;i++){
            SteelModelColors[index+i]=myTopRaw.UpRawColors[i];
        }
        for(int i=0; i< myTopRaw.nVertices*2;i++){
            SteelModelTextureCoordinates[index+i]=myTopRaw.UpRawTextureCoordinates[i];
        }


        index=myTopRaw.nVertices*3;
        for(int i=0; i< myBottomRaw.nVertices*3; i++){
            SteelModelVertices[index+i]=myBottomRaw.DownRawVertices[i];
            SteelModelNormals[index+i]=myBottomRaw.DownRawNormals[i];
        }
        index=myTopRaw.nVertices*4;
        for(int i=0; i< myBottomRaw.nVertices*4;i++){
            SteelModelColors[index+i]=myBottomRaw.DownRawColors[i];
        }
        index=myTopRaw.nVertices*2;
        for(int i=0; i< myBottomRaw.nVertices*2;i++){
            SteelModelTextureCoordinates[index+i]=myBottomRaw.DownRawTextureCoordinates[i];
        }

        index=(myTopRaw.nVertices+myBottomRaw.nVertices)*3;
        for(int i=0; i< myShearSteel.nVertices*3; i++){
            SteelModelVertices[index+i]=myShearSteel.ShearSteelVertices[i];
            SteelModelNormals[index+i]=myShearSteel.ShearSteelNormals[i];
        }
        index=(myTopRaw.nVertices+myBottomRaw.nVertices)*4;
        for(int i=0; i< myShearSteel.nVertices*4;i++){
            SteelModelColors[index+i]=myShearSteel.ShearSteelColors[i];
        }
        index=(myTopRaw.nVertices+myBottomRaw.nVertices)*2;
        for(int i=0; i< myShearSteel.nVertices*2;i++){
            SteelModelTextureCoordinates[index+i]=myShearSteel.ShearSteelTextureCoordinates[i];
        }


    }



    class TopRaw{
        float[] UpRawVertices;
        float[] UpRawColors;
        float[] UpRawNormals;
        float[] UpRawTextureCoordinates;
        int nVertices;
        TopRaw(int n, float R,float B,float H,float L) {
            Cylinder[] myUpCylinder=new Cylinder[n];
            float dyStart=-B/2;
            float dyStep=B/(n-1);
            float dz=H/2;
            //int nRadialCoordinates=20;
            int nRadialCoordinates=10;

            for(int i=0; i<n; i++){
                float dy=dyStart+i*dyStep;
                myUpCylinder[i]=new Cylinder(nRadialCoordinates,L,R,dy,dz);
            }

            nVertices=n*nRadialCoordinates*12;
            int nVerticesPerCyl=nRadialCoordinates*12;
            UpRawVertices=new float[nVertices*3];
            UpRawColors=new float[nVertices*4];
            UpRawNormals=new float[nVertices*3];
            UpRawTextureCoordinates=new float[nVertices*2];

            for(int i=0; i<n; i++){


                int index=i*nVerticesPerCyl*3;

                for(int j=0; j<nVerticesPerCyl*3; j++){
                    UpRawVertices[index+j]=myUpCylinder[i].CylinderVertices[j];
                    UpRawNormals[index+j]=myUpCylinder[i].CylinderNormals[j];
                }


                index=i*nVerticesPerCyl*2;
                for(int j=0; j<nVerticesPerCyl*2; j++){
                    UpRawTextureCoordinates[index+j]=myUpCylinder[i].CylinderTextureCoordinates[j];
                }


                index=i*nVerticesPerCyl*4;
                for(int j=0; j<nVerticesPerCyl*4; j++){
                    UpRawColors[index+j]=myUpCylinder[i].CylinderColors[j];
                }

            }
        }
    }

    class BottomRaw{
        float[] DownRawVertices;
        float[] DownRawColors;
        float[] DownRawNormals;
        float[] DownRawTextureCoordinates;
        int nVertices;
        BottomRaw(int n, float R,float B,float H,float L){
            Cylinder[] myDownCylinder=new Cylinder[n];
            float dyStart=-B/2;
            float dyStep=B/(n-1);
            float dz=-H/2;
            int nRadialCoordinates=10;
            //int nRadialCoordinates=20;
            for(int i=0; i<n; i++){
                float dy=dyStart+i*dyStep;
                myDownCylinder[i]=new Cylinder(nRadialCoordinates,L,R,dy,dz);
            }
            nVertices=n*nRadialCoordinates*12;
            int nVerticesPerCyl=nRadialCoordinates*12;
            DownRawVertices=new float[nVertices*3];
            DownRawColors=new float[nVertices*4];
            DownRawNormals=new float[nVertices*3];
            DownRawTextureCoordinates=new float[nVertices*2];

            for(int i=0; i<n; i++){
                int index=i*nVerticesPerCyl*3;
                for(int j=0; j<nVerticesPerCyl*3; j++){
                    DownRawVertices[index+j]=myDownCylinder[i].CylinderVertices[j];
                    DownRawNormals[index+j]=myDownCylinder[i].CylinderNormals[j];
                }
                index=i*nVerticesPerCyl*2;
                for(int j=0; j<nVerticesPerCyl*2; j++){
                    DownRawTextureCoordinates[index+j]=myDownCylinder[i].CylinderTextureCoordinates[j];
                }
                index=i*nVerticesPerCyl*4;
                for(int j=0; j<nVerticesPerCyl*4; j++){
                    DownRawColors[index+j]=myDownCylinder[i].CylinderColors[j];
                }
            }
        }
    }

    class ShearSteel{
        float[] ShearSteelVertices;
        float[] ShearSteelColors;
        float[] ShearSteelNormals;
        float[] ShearSteelTextureCoordinates;
        int nVertices;
        ShearSteel(float B,float H,float L,float x[],float R,float r){
            int nSteels=x.length;
            Steel[] myShearSteel=new Steel[nSteels];
            float dy=(B-2*R)/2;
            float dz=(H-2*R)/2;
            int Ni=11;
            int Nj=11;
            //int Ni=51;
            //int Nj=21;
            for(int i=0; i<nSteels; i++){
                float dx=(-L/2+x[i]*L);
                myShearSteel[i]=new Steel(Ni,Nj,R,r,dz,dy,dx);
            }
            nVertices=nSteels*Ni * Nj * 6;
            int nVerticesPerShearSteel=Ni * Nj * 6;
            ShearSteelVertices=new float[nVertices*3];
            ShearSteelColors=new float[nVertices*4];
            ShearSteelNormals=new float[nVertices*3];
            ShearSteelTextureCoordinates=new float[nVertices*2];
            for(int i=0; i<nSteels; i++){
                int index=i* nVerticesPerShearSteel*3;
                for(int j=0; j< nVerticesPerShearSteel*3 ; j++){
                    ShearSteelVertices[index+j]=myShearSteel[i].SteelVertices[j];
                    ShearSteelNormals[index+j]=myShearSteel[i].SteelNormals[j];
                }
                index=i*nVerticesPerShearSteel*2;
                for(int j=0; j<nVerticesPerShearSteel*2; j++){
                    ShearSteelTextureCoordinates[index+j]=myShearSteel[i].SteelTextureCoordinates[j];
                }
                index=i*nVerticesPerShearSteel*4;
                for(int j=0; j<nVerticesPerShearSteel*4; j++){
                    ShearSteelColors[index+j]=myShearSteel[i].SteelColors[j];
                }

            }
        }
    }
}
