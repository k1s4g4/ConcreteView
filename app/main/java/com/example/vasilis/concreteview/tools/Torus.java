package com.example.vasilis.concreteview.tools;



public class Torus {
    public float[] TorusVertices;
    public float[] TorusNormals;
    public float[] TorusColors;
    public int nVertices;


    public Torus(int Ni,int Nj,float R,float r){


        nVertices=Ni*Nj*6;
        TorusVertices=new float[Ni*Nj*18];
        TorusNormals=new float[Ni*Nj*18];
        TorusColors=new float[(Ni)*(Nj)*24];
        double deltaI=2*Math.PI / Ni;
        double deltaJ=2*Math.PI / Nj;




        for (int i=0; i <=Ni-1; i++){


            double iangle=i*deltaI, iiangle=(i+1)*deltaI;
            double cosi=Math.cos(iangle), cosii=Math.cos(iiangle);
            double sini=Math.sin(iangle), sinii=Math.sin(iiangle);



            for (int j=0; j <= Nj-1; j++){


                double jangle=j*deltaJ, jjangle=(j+1)*deltaJ;
                double cosj=Math.cos(jangle), cosjj=Math.cos(jjangle);
                double sinj=Math.sin(jangle), sinjj=Math.sin(jjangle);

                int index=i*(Nj)*18+j*18;

                //  TORUS VERTICES
                //Triangle 1
                //Vertex 1
                TorusVertices[index+0]=(float)(cosi*(R+r*cosj));
                TorusVertices[index+1]=(float)(sini*(R+r*cosj)) ;
                TorusVertices[index+2]=(float)(r*sinj);
                //Vertex 2
                TorusVertices[index+3]=(float)(cosii*(R+r*cosj)) ;
                TorusVertices[index+4]=(float)(sinii*(R+r*cosj));
                TorusVertices[index+5]= (float)(r*sinj);
                //Vertex 3
                TorusVertices[index+6]=(float)(cosii*(R+r*cosjj));
                TorusVertices[index+7]= (float)(sinii*(R+r*cosjj));
                TorusVertices[index+8]=(float)(r*sinjj);

                //Triangle 2
                //Vertex 1
                TorusVertices[index+9]= (float)(cosi*(R+r*cosj));
                TorusVertices[index+10]=(float)(sini*(R+r*cosj));
                TorusVertices[index+11]= (float)(r*sinj);
                //Vertex 2
                TorusVertices[index+12]=(float)(cosii*(R+r*cosjj));
                TorusVertices[index+13]= (float)(sinii*(R+r*cosjj));
                TorusVertices[index+14]=(float)(r*sinjj);
                //Vertex 3
                TorusVertices[index+15]= (float)(cosi*(R+r*cosjj));
                TorusVertices[index+16]=(float)(sini*(R+r*cosjj));
                TorusVertices[index+17]=(float)(r*sinjj) ;


                //   TORUS NORMALS

                //Triangle 1

                //Vertex 1
                //t tangent vector with respect to big circle
                float tx=(float)(-sini);
                float ty=(float) cosi ;
                float tz=0;
                //s tangent vector with respect to little circle
                float sx=(float)(cosi*(-sinj));
                float sy=(float)(sini*(-sinj));
                float sz=(float)(cosj);
                //normal is product of tangents
                double nx=ty*sz-tz*sy;
                double ny=tz*sx-tx*sz;
                double nz=tx*sy-ty*sx;
                //normalize normal
                double length=Math.sqrt(nx*nx+ny*ny+nz*nz);
                float nxF=(float)(nx/length);
                float nyF=(float)(ny/length);
                float nzF=(float)(nz/length);
                TorusNormals[index+0]=nxF;
                TorusNormals[index+1]=nyF;
                TorusNormals[index+2]=nzF;

                //Vertex 2
                tx=(float)(-sinii);
                ty=(float) cosii ;
                tz=0;
                sx=(float)(cosii*(-sinj));
                sy=(float)(sinii*(-sinj));
                sz=(float)(cosj);
                nx=ty*sz-tz*sy;
                ny=tz*sx-tx*sz;
                nz=tx*sy-ty*sx;
                length=Math.sqrt(nx*nx+ny*ny+nz*nz);
                nxF=(float)(nx/length);
                nyF=(float)(ny/length);
                nzF=(float)(nz/length);
                TorusNormals[index+3]=nxF;
                TorusNormals[index+4]=nyF;
                TorusNormals[index+5]=nzF;

                //Vertex 3
                tx=(float)(-sinii);
                ty=(float) cosii ;
                tz=0;
                sx=(float)(cosii*(-sinjj));
                sy=(float)(sinii*(-sinjj));
                sz=(float)(cosjj);
                nx=ty*sz-tz*sy;
                ny=tz*sx-tx*sz;
                nz=tx*sy-ty*sx;
                length=Math.sqrt(nx*nx+ny*ny+nz*nz);
                nxF=(float)(nx/length);
                nyF=(float)(ny/length);
                nzF=(float)(nz/length);
                TorusNormals[index+6]=nxF;
                TorusNormals[index+7]=nyF;
                TorusNormals[index+8]=nzF;

                //Triangle2

                //Vertex 1
                tx=(float)(-sini);
                ty=(float) cosi ;
                tz=0;
                sx=(float)(cosi*(-sinj));
                sy=(float)(sini*(-sinj));
                sz=(float)(cosj);
                nx=ty*sz-tz*sy;
                ny=tz*sx-tx*sz;
                nz=tx*sy-ty*sx;
                length=Math.sqrt(nx*nx+ny*ny+nz*nz);
                nxF=(float)(nx/length);
                nyF=(float)(ny/length);
                nzF=(float)(nz/length);
                TorusNormals[index+9]=nxF;
                TorusNormals[index+10]=nyF;
                TorusNormals[index+11]=nzF;

                //Vertex 2
                tx=(float)(-sinii);
                ty=(float) cosii ;
                tz=0;
                sx=(float)(cosii*(-sinjj));
                sy=(float)(sinii*(-sinjj));
                sz=(float)(cosjj);
                nx=ty*sz-tz*sy;
                ny=tz*sx-tx*sz;
                nz=tx*sy-ty*sx;
                length=Math.sqrt(nx*nx+ny*ny+nz*nz);
                nxF=(float)(nx/length);
                nyF=(float)(ny/length);
                nzF=(float)(nz/length);
                TorusNormals[index+12]=nxF;
                TorusNormals[index+13]=nyF;
                TorusNormals[index+14]=nzF;

                //Vertex 3
                tx=(float)(-sini);
                ty=(float) cosi ;
                tz=0;
                sx=(float)(cosi*(-sinjj));
                sy=(float)(sini*(-sinjj));
                sz=(float)(cosjj);
                nx=ty*sz-tz*sy;
                ny=tz*sx-tx*sz;
                nz=tx*sy-ty*sx;
                length=Math.sqrt(nx*nx+ny*ny+nz*nz);
                nxF=(float)(nx/length);
                nyF=(float)(ny/length);
                nzF=(float)(nz/length);
                TorusNormals[index+15]=nxF;
                TorusNormals[index+16]=nyF;
                TorusNormals[index+17]=nzF;


                index=i*(Nj)*24+j*24;


                TorusColors[index+0]=0.0f;
                TorusColors[index+1]=1.0f;
                TorusColors[index+2]=0.0f;
                TorusColors[index+3]=1.0f;

                TorusColors[index+4]=0.0f;
                TorusColors[index+5]=1.0f;
                TorusColors[index+6]=0.0f;
                TorusColors[index+7]=1.0f;

                TorusColors[index+8]=0.0f;
                TorusColors[index+9]=1.0f;
                TorusColors[index+10]=0.0f;
                TorusColors[index+11]=1.0f;

                TorusColors[index+12]=0.0f;
                TorusColors[index+13]=1.0f;
                TorusColors[index+14]=0.0f;
                TorusColors[index+15]=1.0f;

                TorusColors[index+16]=0.0f;
                TorusColors[index+17]=1.0f;
                TorusColors[index+18]=0.0f;
                TorusColors[index+19]=1.0f;

                TorusColors[index+20]=0.0f;
                TorusColors[index+21]=1.0f;
                TorusColors[index+22]=0.0f;
                TorusColors[index+23]=1.0f;


            }
        }
    }
}
