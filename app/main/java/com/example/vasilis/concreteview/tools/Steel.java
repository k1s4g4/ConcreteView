package com.example.vasilis.concreteview.tools;


import com.example.vasilis.concreteview.MainActivity;

public class Steel {
    public float[] SteelVertices;
    public float[] SteelNormals;
    public float[] SteelColors;
    public float[] SteelTextureCoordinates;
    public int nVertices;
    public Steel(int Ni,int Nj,float R,float r,float dz,float dy,float dx) {


        nVertices =  Ni * Nj * 6;
        SteelVertices = new float[Ni * Nj * 18];
        SteelNormals = new float[ Ni * Nj * 18];
        SteelColors = new float[ (Ni) * (Nj) * 24];
        SteelTextureCoordinates=new float[(Ni)*Nj*12];
        double deltaI = 2 * Math.PI / Ni;
        double deltaJ = 2 * Math.PI / Nj;
        float dzi = dz, dzii = dz, dyi = dy, dyii = dy;



        for (int i = 0; i <= Ni - 1; i++) {


                double iangle = i * deltaI, iiangle = (i + 1) * deltaI;
                double cosi = Math.cos(iangle), cosii = Math.cos(iiangle);
                double sini = Math.sin(iangle), sinii = Math.sin(iiangle);

                if (iangle < Math.PI / 2) {
                    dzi = dzii = Math.abs(dz);
                    dyi = dyii = Math.abs(dy);
                    if (iiangle > Math.PI / 2) {
                        dzii = -Math.abs(dz);
                    }
                } else if (iangle < Math.PI) {
                    dzi = dzii = -Math.abs(dz);
                    dyi = dyii = Math.abs(dy);
                    if (iiangle > Math.PI) {
                        dyii = -Math.abs(dy);
                    }
                } else if (iangle < 3 * Math.PI / 2) {
                    dzi = dzii = -Math.abs(dz);
                    dyi = dyii = -Math.abs(dy);
                    if (iiangle > 3 * Math.PI / 2) {
                        dzii = Math.abs(dz);
                    }
                } else if (iangle < 2 * Math.PI) {
                    dzi = dzii = Math.abs(dz);
                    dyi = dyii = -Math.abs(dy);
                    if (2 * Math.PI - iiangle < deltaI) {
                        dyii = Math.abs(dy);
                    }
                }

                for (int j = 0; j <= Nj - 1; j++) {


                    double jangle = j * deltaJ, jjangle = (j + 1) * deltaJ;
                    double cosj = Math.cos(jangle), cosjj = Math.cos(jjangle);
                    double sinj = Math.sin(jangle), sinjj = Math.sin(jjangle);

                    int index =  i * (Nj) * 18 + j* 18;

                    //  TORUS VERTICES
                    //Triangle 1
                    //Vertex 1
                    SteelVertices[index + 0] = (float) (r * sinj+dx);
                    SteelVertices[index + 1] = (float) (sini * (R + r * cosj) + dyi);
                    SteelVertices[index + 2] = (float) (cosi * (R + r * cosj) + dzi);
                    //Vertex 2
                    SteelVertices[index + 3] = (float) (r * sinjj+dx);
                    SteelVertices[index + 4] = (float) (sinii * (R + r * cosjj) + dyii);
                    SteelVertices[index + 5] = (float) (cosii * (R + r * cosjj) + dzii);
                    //Vertex 3
                    SteelVertices[index + 6] = (float) (r * sinj+dx);
                    SteelVertices[index + 7] = (float) (sinii * (R + r * cosj) + dyii);
                    SteelVertices[index + 8] = (float) (cosii * (R + r * cosj) + dzii);

                    //Triangle 2
                    //Vertex 1
                    SteelVertices[index + 9] = (float) (r * sinj+dx);
                    SteelVertices[index + 10] = (float) (sini * (R + r * cosj) + dyi);
                    SteelVertices[index + 11] = (float) (cosi * (R + r * cosj) + dzi);
                    //Vertex 2
                    SteelVertices[index + 12] = (float) (r * sinjj+dx);
                    SteelVertices[index + 13] = (float) (sini * (R + r * cosjj) + dyi);
                    SteelVertices[index + 14] = (float) (cosi * (R + r * cosjj) + dzi);
                    //Vertex 3
                    SteelVertices[index + 15] = (float) (r * sinjj+dx);
                    SteelVertices[index + 16] = (float) (sinii * (R + r * cosjj) + dyii);
                    SteelVertices[index + 17] = (float) (cosii * (R + r * cosjj) + dzii);


                    //   TORUS NORMALS

                    //Triangle 1

                    //Vertex 1
                    //t tangent vector with respect to big circle
                    float tx = 0;
                    float ty = (float) cosi;
                    float tz = (float) (-sini);
                    //s tangent vector with respect to little circle
                    float sx = (float) (cosj);
                    float sy = (float) (sini * (-sinj));
                    float sz = (float) (cosi * (-sinj));
                    //normal is product of tangents
                    double nx = -(ty * sz - tz * sy);
                    double ny = -(tz * sx - tx * sz);
                    double nz = -(tx * sy - ty * sx);
                    //normalize normal
                    double length = Math.sqrt(nx * nx + ny * ny + nz * nz);
                    float nxF = (float) (nx / length);
                    float nyF = (float) (ny / length);
                    float nzF = (float) (nz / length);
                    SteelNormals[index + 0] = nxF;
                    SteelNormals[index + 1] = nyF;
                    SteelNormals[index + 2] = nzF;

                    //Vertex 2
                    tx = 0;
                    ty = (float) cosii;
                    tz = (float) (-sinii);
                    sx = (float) (cosjj);
                    sy = (float) (sinii * (-sinjj));
                    sz = (float) (cosii * (-sinjj));
                    nx = -(ty * sz - tz * sy);
                    ny = -(tz * sx - tx * sz);
                    nz = -(tx * sy - ty * sx);
                    length = Math.sqrt(nx * nx + ny * ny + nz * nz);
                    nxF = (float) (nx / length);
                    nyF = (float) (ny / length);
                    nzF = (float) (nz / length);
                    SteelNormals[index + 3] = nxF;
                    SteelNormals[index + 4] = nyF;
                    SteelNormals[index + 5] = nzF;


                    //Vertex 3
                    tx = 0;
                    ty = (float) cosii;
                    tz = (float) (-sinii);
                    sx = (float) (cosj);
                    sy = (float) (sinii * (-sinj));
                    sz = (float) (cosii * (-sinj));
                    nx = -(ty * sz - tz * sy);
                    ny = -(tz * sx - tx * sz);
                    nz = -(tx * sy - ty * sx);
                    length = Math.sqrt(nx * nx + ny * ny + nz * nz);
                    nxF = (float) (nx / length);
                    nyF = (float) (ny / length);
                    nzF = (float) (nz / length);
                    SteelNormals[index + 6] = nxF;
                    SteelNormals[index + 7] = nyF;
                    SteelNormals[index + 8] = nzF;

                    //Triangle2

                    //Vertex 1
                    tx = 0;
                    ty = (float) cosi;
                    tz = (float) (-sini);
                    sx = (float) (cosj);
                    sy = (float) (sini * (-sinj));
                    sz = (float) (cosi * (-sinj));
                    nx = -(ty * sz - tz * sy);
                    ny = -(tz * sx - tx * sz);
                    nz = -(tx * sy - ty * sx);
                    length = Math.sqrt(nx * nx + ny * ny + nz * nz);
                    nxF = (float) (nx / length);
                    nyF = (float) (ny / length);
                    nzF = (float) (nz / length);
                    SteelNormals[index + 9] = nxF;
                    SteelNormals[index + 10] = nyF;
                    SteelNormals[index + 11] = nzF;

                    //Vertex 2
                    tx = 0;
                    ty = (float) cosi;
                    tz = (float) (-sini);
                    sx = (float) (cosjj);
                    sy = (float) (sini * (-sinjj));
                    sz = (float) (cosi * (-sinjj));
                    nx = -(ty * sz - tz * sy);
                    ny = -(tz * sx - tx * sz);
                    nz = -(tx * sy - ty * sx);
                    length = Math.sqrt(nx * nx + ny * ny + nz * nz);
                    nxF = (float) (nx / length);
                    nyF = (float) (ny / length);
                    nzF = (float) (nz / length);
                    SteelNormals[index + 12] = nxF;
                    SteelNormals[index + 13] = nyF;
                    SteelNormals[index + 14] = nzF;

                    //Vertex 3
                    tx = 0;
                    ty = (float) cosii;
                    tz = (float) (-sinii);
                    sx = (float) (cosjj);
                    sy = (float) (sinii * (-sinjj));
                    sz = (float) (cosii * (-sinjj));
                    nx = -(ty * sz - tz * sy);
                    ny = -(tz * sx - tx * sz);
                    nz = -(tx * sy - ty * sx);
                    length = Math.sqrt(nx * nx + ny * ny + nz * nz);
                    nxF = (float) (nx / length);
                    nyF = (float) (ny / length);
                    nzF = (float) (nz / length);
                    SteelNormals[index + 15] = nxF;
                    SteelNormals[index + 16] = nyF;
                    SteelNormals[index + 17] = nzF;

                    index = i * (Nj) * 24 + j * 24;


                    SteelColors[index + 0] = 0.5f;
                    SteelColors[index + 1] = 0.5f;
                    SteelColors[index + 2] = 0.5f;
                    SteelColors[index + 3] = 1.0f;

                    SteelColors[index + 4] = 0.5f;
                    SteelColors[index + 5] = 0.5f;
                    SteelColors[index + 6] = 0.5f;
                    SteelColors[index + 7] = 1.0f;

                    SteelColors[index + 8] = 0.5f;
                    SteelColors[index + 9] = 0.5f;
                    SteelColors[index + 10] = 0.5f;
                    SteelColors[index + 11] = 1.0f;

                    SteelColors[index + 12] = 0.5f;
                    SteelColors[index + 13] = 0.5f;
                    SteelColors[index + 14] = 0.5f;
                    SteelColors[index + 15] = 1.0f;

                    SteelColors[index + 16] = 0.5f;
                    SteelColors[index + 17] = 0.5f;
                    SteelColors[index + 18] = 0.5f;
                    SteelColors[index + 19] = 1.0f;

                    SteelColors[index + 20] = 0.5f;
                    SteelColors[index + 21] = 0.5f;
                    SteelColors[index + 22] = 0.5f;
                    SteelColors[index + 23] = 1.0f;


                    index = i * (Nj) * 12 + j * 12;
                    float xScalar=3;
                    if( dzi==dzii && dyi==dyii) {

                        SteelTextureCoordinates[index + 0] = (float) (xScalar*(Math.PI*R /(dz))* iangle / (2 * Math.PI));
                        SteelTextureCoordinates[index + 1] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 2] = (float) (xScalar *(Math.PI*R /(dz))* iiangle / (2 * Math.PI));
                        SteelTextureCoordinates[index + 3] = (float) (1 * jjangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 4] = (float) (xScalar *(Math.PI*R /(dz))* iiangle / (2 * Math.PI));
                        SteelTextureCoordinates[index + 5] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 6] = (float) (xScalar * (Math.PI*R /(dz))*iangle / (2 * Math.PI));
                        SteelTextureCoordinates[index + 7] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 8] = (float) (xScalar * (Math.PI*R /(dz))*iangle / (2 * Math.PI));
                        SteelTextureCoordinates[index + 9] = (float) (1 * jjangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 10] = (float) (xScalar *(Math.PI*R /(dz))* iiangle / (2 * Math.PI));
                        SteelTextureCoordinates[index + 11] = (float) (1 * jjangle / (2 * Math.PI));

                    }else if( dzi != dzii ){

                        SteelTextureCoordinates[index + 0] = (float) 0;
                        SteelTextureCoordinates[index + 1] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 2] = (float) xScalar;
                        SteelTextureCoordinates[index + 3] = (float) (1 * jjangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 4] = (float) xScalar;
                        SteelTextureCoordinates[index + 5] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 6] = (float) 0;
                        SteelTextureCoordinates[index + 7] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 8] = (float) 0;
                        SteelTextureCoordinates[index + 9] = (float) (1 * jjangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 10] = (float) xScalar;
                        SteelTextureCoordinates[index + 11] = (float) (1 * jjangle / (2 * Math.PI));

                    }else if( dyi != dyii ){

                        SteelTextureCoordinates[index + 0] = (float) 0;
                        SteelTextureCoordinates[index + 1] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 2] = (float) xScalar*dy/dz;
                        SteelTextureCoordinates[index + 3] = (float) (1 * jjangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 4] = (float) xScalar*dy/dz;
                        SteelTextureCoordinates[index + 5] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 6] = (float) 0;
                        SteelTextureCoordinates[index + 7] = (float) (1 * jangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 8] = (float) 0;
                        SteelTextureCoordinates[index + 9] = (float) (1 * jjangle / (2 * Math.PI));

                        SteelTextureCoordinates[index + 10] = (float) xScalar*dy/dz;
                        SteelTextureCoordinates[index + 11] = (float) (1 * jjangle / (2 * Math.PI));


                    }

                }
        }

    }
}
