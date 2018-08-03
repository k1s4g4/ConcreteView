package com.example.vasilis.concreteview.tools;



public class Concrete {
    public float[] ConcreteVertices;
    public float[] ConcreteNormals;
    public float[] ConcreteColors;
    public float[] ConcreteTextureCoordinates;
    public int nVertices;
    public Concrete(float B,float L,float H,float dh,float alpha){
        nVertices = 36;
        ConcreteVertices = new float[108];
        ConcreteNormals = new float[108];
        ConcreteColors = new float[144];
        ConcreteTextureCoordinates=new float[72];

        // VERTICES

        //TRIANGLE 1
        //Vertex1
        ConcreteVertices[0] =  (L/2);
        ConcreteVertices[1] = (B/2);
        ConcreteVertices[2] = (-H/2);
        //Vertex2
        ConcreteVertices[3] =  (L/2);
        ConcreteVertices[4] = (B/2);
        ConcreteVertices[5] = (H/2);
        //Vertex3
        ConcreteVertices[6] =  (L/2);
        ConcreteVertices[7] = (-B/2);
        ConcreteVertices[8] = (H/2);

        //TRIANGLE 2
        //Vertex1
        ConcreteVertices[9] =  (L/2);
        ConcreteVertices[10] = (B/2);
        ConcreteVertices[11] = (-H/2);
        //Vertex2
        ConcreteVertices[12] =  (L/2);
        ConcreteVertices[13] = (-B/2);
        ConcreteVertices[14] = (H/2);
        //Vertex3
        ConcreteVertices[15] =  (L/2);
        ConcreteVertices[16] = (-B/2);
        ConcreteVertices[17] = (-H/2);



        //TRIANGLE 3
        //Vertex1
        ConcreteVertices[18] =  (L/2);
        ConcreteVertices[19] = (-B/2);
        ConcreteVertices[20] = (H/2);
        //Vertex2
        ConcreteVertices[21] =  (L/2);
        ConcreteVertices[22] = (B/2);
        ConcreteVertices[23] = (H/2);
        //Vertex3
        ConcreteVertices[24] =  (-L/2);
        ConcreteVertices[25] = (B/2);
        ConcreteVertices[26] = (H/2);


        //TRIANGLE 4
        //Vertex1
        ConcreteVertices[27] =  (L/2);
        ConcreteVertices[28] = (-B/2);
        ConcreteVertices[29] = (H/2);
        //Vertex2
        ConcreteVertices[30] =  (-L/2);
        ConcreteVertices[31] = (B/2);
        ConcreteVertices[32] = (H/2);
        //Vertex3
        ConcreteVertices[33] =  (-L/2);
        ConcreteVertices[34] = (-B/2);
        ConcreteVertices[35] = (H/2);

        //TRIANGLE 5
        //Vertex1
        ConcreteVertices[36] =  (-L/2);
        ConcreteVertices[37] =(-B/2);
        ConcreteVertices[38] = (H/2);
        //Vertex2
        ConcreteVertices[39] =  (-L/2);
        ConcreteVertices[40] = (B/2);
        ConcreteVertices[41] = (H/2);
        //Vertex3
        ConcreteVertices[42] =  (-L/2);
        ConcreteVertices[43] = (B/2);
        ConcreteVertices[44] = (-H/2);


        //TRIANGLE 6
        //Vertex1
        ConcreteVertices[45] =  (-L/2);
        ConcreteVertices[46] = (-B/2);
        ConcreteVertices[47] = (H/2);
        //Vertex2
        ConcreteVertices[48] =  (-L/2);
        ConcreteVertices[49] = (B/2);
        ConcreteVertices[50] = (-H/2);
        //Vertex3
        ConcreteVertices[51] =  (-L/2);
        ConcreteVertices[52] = (-B/2);
        ConcreteVertices[53] = (-H/2);


        //TRIANGLE 7
        //Vertex1
        ConcreteVertices[54] = (-L/2);
        ConcreteVertices[55] = (-B/2);
        ConcreteVertices[56] = (-H/2);
        //Vertex2
        ConcreteVertices[57] = (-L/2);
        ConcreteVertices[58] = (B/2);
        ConcreteVertices[59] = (-H/2);
        //Vertex3
        ConcreteVertices[60] = (L/2);
        ConcreteVertices[61] = (-B/2);
        ConcreteVertices[62] = (-H/2);


        //TRIANGLE 8
        //Vertex1
        ConcreteVertices[63] = (-L/2);
        ConcreteVertices[64] = (B/2);
        ConcreteVertices[65] = (-H/2);
        //Vertex2
        ConcreteVertices[66] = (L/2);
        ConcreteVertices[67] = (B/2);
        ConcreteVertices[68] = (-H/2);
        //Vertex3
        ConcreteVertices[69] = (L/2);
        ConcreteVertices[70] = (-B/2);
        ConcreteVertices[71] = (-H/2);


        //TRIANGLE 9
        //Vertex1
        ConcreteVertices[72] = (-L/2);
        ConcreteVertices[73] = (-B/2);
        ConcreteVertices[74] = (-H/2);
        //Vertex2
        ConcreteVertices[75] = (L/2);
        ConcreteVertices[76] = (-B/2);
        ConcreteVertices[77] = (-H/2);
        //Vertex3
        ConcreteVertices[78] = (-L/2);
        ConcreteVertices[79] = (-B/2);
        ConcreteVertices[80] = (H/2);


        //TRIANGLE 10
        //Vertex1
        ConcreteVertices[81] = (-L/2);
        ConcreteVertices[82] = (-B/2);
        ConcreteVertices[83] = (H/2);
        //Vertex2
        ConcreteVertices[84] = (L/2);
        ConcreteVertices[85] = (-B/2);
        ConcreteVertices[86] = (-H/2);
        //Vertex3
        ConcreteVertices[87] = (L/2);
        ConcreteVertices[88] = (-B/2);
        ConcreteVertices[89] = (H/2);


        //TRIANGLE 11
        //Vertex1
        ConcreteVertices[90] = (-L/2);
        ConcreteVertices[91] = (B/2);
        ConcreteVertices[92] = (-H/2);
        //Vertex2
        ConcreteVertices[93] = (-L/2);
        ConcreteVertices[94] = (B/2);
        ConcreteVertices[95] = (H/2);
        //Vertex3
        ConcreteVertices[96] = (L/2);
        ConcreteVertices[97] = (B/2);
        ConcreteVertices[98] = (-H/2);


        //TRIANGLE 12
        //Vertex1
        ConcreteVertices[99]  = (-L/2);
        ConcreteVertices[100] = (B/2);
        ConcreteVertices[101] = (H/2);
        //Vertex2
        ConcreteVertices[102] = (L/2);
        ConcreteVertices[103] = (B/2);
        ConcreteVertices[104] = (H/2);
        //Vertex3
        ConcreteVertices[105] = (L/2);
        ConcreteVertices[106] = (B/2);
        ConcreteVertices[107] = (-H/2);


        //  CONCRETE COLORS

        //TRIANGLE 1
        //Vertex1
        ConcreteColors[0] = 1.0f ;
        ConcreteColors[1] = 1.0f;
        ConcreteColors[2] = 1.0f;
        ConcreteColors[3] = alpha;
        //Vertex2
        ConcreteColors[4] = 1.0f ;
        ConcreteColors[5] = 1.0f;
        ConcreteColors[6] = 1.0f;
        ConcreteColors[7] = alpha;
        //Vertex3
        ConcreteColors[8] =  1.0f ;
        ConcreteColors[9] =  1.0f;
        ConcreteColors[10] =  1.0f;
        ConcreteColors[11] = alpha;

        //TRIANGLE 2
        //Vertex1
        ConcreteColors[12] = 1.0f ;
        ConcreteColors[13] = 1.0f;
        ConcreteColors[14] = 1.0f;
        ConcreteColors[15] = alpha;
        //Vertex2
        ConcreteColors[16] = 1.0f ;
        ConcreteColors[17] = 1.0f;
        ConcreteColors[18] = 1.0f;
        ConcreteColors[19] = alpha;
        //Vertex3
        ConcreteColors[20] =  1.0f ;
        ConcreteColors[21] =  1.0f;
        ConcreteColors[22] =  1.0f;
        ConcreteColors[23] = alpha;

        //TRIANGLE 3
        //Vertex1
        ConcreteColors[24] = 1.0f ;
        ConcreteColors[25] = 1.0f;
        ConcreteColors[26] = 1.0f;
        ConcreteColors[27] = alpha;
        //Vertex2
        ConcreteColors[28] = 1.0f ;
        ConcreteColors[29] = 1.0f;
        ConcreteColors[30] = 1.0f;
        ConcreteColors[31] = alpha;
        //Vertex3
        ConcreteColors[32] =  1.0f ;
        ConcreteColors[33] =  1.0f;
        ConcreteColors[34] =  1.0f;
        ConcreteColors[35] = alpha;

        //TRIANGLE 4
        //Vertex1
        ConcreteColors[36] = 1.0f ;
        ConcreteColors[37] = 1.0f;
        ConcreteColors[38] = 1.0f;
        ConcreteColors[39] = alpha;
        //Vertex2
        ConcreteColors[40] = 1.0f ;
        ConcreteColors[41] = 1.0f;
        ConcreteColors[42] = 1.0f;
        ConcreteColors[43] = alpha;
        //Vertex3
        ConcreteColors[44] = 1.0f ;
        ConcreteColors[45] = 1.0f;
        ConcreteColors[46] = 1.0f;
        ConcreteColors[47] = alpha;

        //TRIANGLE 5
        //Vertex1
        ConcreteColors[48] = 1.0f ;
        ConcreteColors[49] = 1.0f;
        ConcreteColors[50] = 1.0f;
        ConcreteColors[51] = alpha;
        //Vertex2
        ConcreteColors[52] =  1.0f ;
        ConcreteColors[53] =  1.0f;
        ConcreteColors[54] =  1.0f;
        ConcreteColors[55] = alpha;
        //Vertex3
        ConcreteColors[56] = 1.0f ;
        ConcreteColors[57] = 1.0f;
        ConcreteColors[58] = 1.0f;
        ConcreteColors[59] = alpha;

        //TRIANGLE 6
        //Vertex1
        ConcreteColors[60] = 1.0f ;
        ConcreteColors[61] = 1.0f;
        ConcreteColors[62] = 1.0f;
        ConcreteColors[63] = alpha;
        //Vertex2
        ConcreteColors[64] =  1.0f ;
        ConcreteColors[65] =  1.0f;
        ConcreteColors[66] =  1.0f;
        ConcreteColors[67] = alpha;
        //Vertex3
        ConcreteColors[68] = 1.0f ;
        ConcreteColors[69] = 1.0f;
        ConcreteColors[70] = 1.0f;
        ConcreteColors[71] = alpha;

        //TRIANGLE 7
        //Vertex1
        ConcreteColors[72] = 1.0f ;
        ConcreteColors[73] = 1.0f;
        ConcreteColors[74] = 1.0f;
        ConcreteColors[75] = alpha;
        //Vertex2
        ConcreteColors[76] =  1.0f ;
        ConcreteColors[77] =  1.0f;
        ConcreteColors[78] =  1.0f;
        ConcreteColors[79] = alpha;
        //Vertex3
        ConcreteColors[80] = 1.0f ;
        ConcreteColors[81] = 1.0f;
        ConcreteColors[82] = 1.0f;
        ConcreteColors[83] = alpha;

        //TRIANGLE 8
        //Vertex1
        ConcreteColors[84] = 1.0f ;
        ConcreteColors[85] = 1.0f;
        ConcreteColors[86] = 1.0f;
        ConcreteColors[87] = alpha;
        //Vertex2
        ConcreteColors[88] =  1.0f ;
        ConcreteColors[89] =  1.0f;
        ConcreteColors[90] =  1.0f;
        ConcreteColors[91] = alpha;
        //Vertex3
        ConcreteColors[92] = 1.0f ;
        ConcreteColors[93] = 1.0f;
        ConcreteColors[94] = 1.0f;
        ConcreteColors[95] = alpha;

        //TRIANGLE 9
        //Vertex1
        ConcreteColors[96] = 1.0f ;
        ConcreteColors[97] = 1.0f;
        ConcreteColors[98] = 1.0f;
        ConcreteColors[99] = alpha;
        //Vertex2
        ConcreteColors[100] =  1.0f ;
        ConcreteColors[101] =  1.0f;
        ConcreteColors[102] =  1.0f;
        ConcreteColors[103] = alpha;
        //Vertex3
        ConcreteColors[104] = 1.0f ;
        ConcreteColors[105] = 1.0f;
        ConcreteColors[106] = 1.0f;
        ConcreteColors[107] = alpha;

        //TRIANGLE 10
        //Vertex1
        ConcreteColors[108] = 1.0f ;
        ConcreteColors[109] = 1.0f;
        ConcreteColors[110] = 1.0f;
        ConcreteColors[111] = alpha;
        //Vertex2
        ConcreteColors[112] =  1.0f ;
        ConcreteColors[113] =  1.0f;
        ConcreteColors[114] =  1.0f;
        ConcreteColors[115] = alpha;
        //Vertex3
        ConcreteColors[116] = 1.0f ;
        ConcreteColors[117] = 1.0f;
        ConcreteColors[118] = 1.0f;
        ConcreteColors[119] = alpha;

        //TRIANGLE 11
        //Vertex1
        ConcreteColors[120] = 1.0f ;
        ConcreteColors[121] = 1.0f;
        ConcreteColors[122] = 1.0f;
        ConcreteColors[123] = alpha;
        //Vertex2
        ConcreteColors[124] =  1.0f ;
        ConcreteColors[125] =  1.0f;
        ConcreteColors[126] =  1.0f;
        ConcreteColors[127] = alpha;
        //Vertex3
        ConcreteColors[128] = 1.0f ;
        ConcreteColors[129] = 1.0f;
        ConcreteColors[130] = 1.0f;
        ConcreteColors[131] = alpha;

        //TRIANGLE 12
        //Vertex1
        ConcreteColors[132] = 1.0f ;
        ConcreteColors[133] = 1.0f;
        ConcreteColors[134] = 1.0f;
        ConcreteColors[135] = alpha;
        //Vertex2
        ConcreteColors[136] =  1.0f ;
        ConcreteColors[137] =  1.0f;
        ConcreteColors[138] =  1.0f;
        ConcreteColors[139] = alpha;
        //Vertex3
        ConcreteColors[140] =  1.0f ;
        ConcreteColors[141] =  1.0f;
        ConcreteColors[142] =  1.0f;
        ConcreteColors[143] = alpha;


        //TRIANGLE 12
        //Vertex1
        ConcreteColors[132] = 1.0f ;
        ConcreteColors[133] = 1.0f;
        ConcreteColors[134] = 1.0f;
        ConcreteColors[135] = alpha;
        //Vertex2
        ConcreteColors[136] =  1.0f ;
        ConcreteColors[137] =  1.0f;
        ConcreteColors[138] =  1.0f;
        ConcreteColors[139] = alpha;
        //Vertex3
        ConcreteColors[140] =  1.0f ;
        ConcreteColors[141] =  1.0f;
        ConcreteColors[142] =  1.0f;
        ConcreteColors[143] = alpha;


        // CONCRETE NORMALS

        //TRIANGLE 1
        //Vertex1
        ConcreteNormals[0] = 1.0f ;
        ConcreteNormals[1] = 0.0f;
        ConcreteNormals[2] = 0.0f;
        //Vertex2
        ConcreteNormals[3] = 1.0f ;
        ConcreteNormals[4] = 0.0f;
        ConcreteNormals[5] = 0.0f;
        //Vertex3
        ConcreteNormals[6] = 1.0f ;
        ConcreteNormals[7] = 0.0f;
        ConcreteNormals[8] = 0.0f;

        //TRIANGLE 2
        //Vertex1
        ConcreteNormals[9] = 1.0f ;
        ConcreteNormals[10] = 0.0f;
        ConcreteNormals[11] = 0.0f;
        //Vertex2
        ConcreteNormals[12] = 1.0f ;
        ConcreteNormals[13] = 0.0f;
        ConcreteNormals[14] = 0.0f;
        //Vertex3
        ConcreteNormals[15] = 1.0f ;
        ConcreteNormals[16] = 0.0f;
        ConcreteNormals[17] = 0.0f;

        //TRIANGLE 3
        //Vertex1
        ConcreteNormals[18] = 0.0f ;
        ConcreteNormals[19] = 0.0f;
        ConcreteNormals[20] = 1.0f;
        //Vertex2
        ConcreteNormals[21] = 0.0f ;
        ConcreteNormals[22] = 0.0f;
        ConcreteNormals[23] = 1.0f;
        //Vertex3
        ConcreteNormals[24] = 0.0f ;
        ConcreteNormals[25] = 0.0f;
        ConcreteNormals[26] = 1.0f;

        //TRIANGLE 4
        //Vertex1
        ConcreteNormals[27] = 0.0f ;
        ConcreteNormals[28] = 0.0f;
        ConcreteNormals[29] = 1.0f;
        //Vertex2
        ConcreteNormals[30] = 0.0f ;
        ConcreteNormals[31] = 0.0f;
        ConcreteNormals[32] = 1.0f;
        //Vertex3
        ConcreteNormals[33] = 0.0f ;
        ConcreteNormals[34] = 0.0f;
        ConcreteNormals[35] = 1.0f;

        //TRIANGLE 5
        //Vertex1
        ConcreteNormals[36] = -1.0f ;
        ConcreteNormals[37] = 0.0f;
        ConcreteNormals[38] = 0.0f;
        //Vertex2
        ConcreteNormals[39] = -1.0f ;
        ConcreteNormals[40] = 0.0f;
        ConcreteNormals[41] = 0.0f;
        //Vertex3
        ConcreteNormals[42] = -1.0f ;
        ConcreteNormals[43] = 0.0f;
        ConcreteNormals[44] = 0.0f;

        //TRIANGLE 6
        //Vertex1
        ConcreteNormals[45] = -1.0f ;
        ConcreteNormals[46] = 0.0f;
        ConcreteNormals[47] = 0.0f;
        //Vertex2
        ConcreteNormals[48] = -1.0f ;
        ConcreteNormals[49] = 0.0f;
        ConcreteNormals[50] = 0.0f;
        //Vertex3
        ConcreteNormals[51] = -1.0f ;
        ConcreteNormals[52] = 0.0f;
        ConcreteNormals[53] = 0.0f;

        //TRIANGLE 7
        //Vertex1
        ConcreteNormals[54] = 0.0f ;
        ConcreteNormals[55] = 0.0f;
        ConcreteNormals[56] = -1.0f;
        //Vertex2
        ConcreteNormals[57] = 0.0f ;
        ConcreteNormals[58] = 0.0f;
        ConcreteNormals[59] = -1.0f;
        //Vertex3
        ConcreteNormals[60] = 0.0f ;
        ConcreteNormals[61] = 0.0f;
        ConcreteNormals[62] = -1.0f;

        //TRIANGLE 8
        //Vertex1
        ConcreteNormals[63] = 0.0f ;
        ConcreteNormals[64] = 0.0f;
        ConcreteNormals[65] = -1.0f;
        //Vertex2
        ConcreteNormals[66] = 0.0f ;
        ConcreteNormals[67] = 0.0f;
        ConcreteNormals[68] = -1.0f;
        //Vertex3
        ConcreteNormals[69] = 0.0f ;
        ConcreteNormals[70] = 0.0f;
        ConcreteNormals[71] = -1.0f;

        //TRIANGLE 9
        //Vertex1
        ConcreteNormals[72] = 0.0f ;
        ConcreteNormals[73] = -1.0f;
        ConcreteNormals[74] = 0.0f;
        //Vertex2
        ConcreteNormals[75] = 0.0f ;
        ConcreteNormals[76] = -1.0f;
        ConcreteNormals[77] = 0.0f;
        //Vertex3
        ConcreteNormals[78] = 0.0f ;
        ConcreteNormals[79] = -1.0f;
        ConcreteNormals[80] = 0.0f;

        //TRIANGLE 10
        //Vertex1
        ConcreteNormals[81] = 0.0f ;
        ConcreteNormals[82] = -1.0f;
        ConcreteNormals[83] = 0.0f;
        //Vertex2
        ConcreteNormals[84] = 0.0f ;
        ConcreteNormals[85] = -1.0f;
        ConcreteNormals[86] = 0.0f;
        //Vertex3
        ConcreteNormals[87] = 0.0f ;
        ConcreteNormals[88] = -1.0f;
        ConcreteNormals[89] = 0.0f;

        //TRIANGLE 11
        //Vertex1
        ConcreteNormals[90] = 0.0f ;
        ConcreteNormals[91] = 1.0f;
        ConcreteNormals[92] = 0.0f;
        //Vertex2
        ConcreteNormals[93] = 0.0f ;
        ConcreteNormals[94] = 1.0f;
        ConcreteNormals[95] = 0.0f;
        //Vertex3
        ConcreteNormals[96] = 0.0f ;
        ConcreteNormals[97] = 1.0f;
        ConcreteNormals[98] = 0.0f;

        //TRIANGLE 12
        //Vertex1
        ConcreteNormals[99] =  0.0f ;
        ConcreteNormals[100] = 1.0f;
        ConcreteNormals[101] = 0.0f;
        //Vertex2
        ConcreteNormals[102] = 0.0f ;
        ConcreteNormals[103] = 1.0f;
        ConcreteNormals[104] = 0.0f;
        //Vertex3
        ConcreteNormals[105] = 0.0f ;
        ConcreteNormals[106] = 1.0f;
        ConcreteNormals[107] = 0.0f;

        // CONCRETE TEXTURE COORDINATES

        float hb=H/B;
        float hl=L/H;

        //TRIANGLE 1
        //Vertex1
        ConcreteTextureCoordinates[0]=1.0f;
        ConcreteTextureCoordinates[1]=0.0f;
        //Vertex2
        ConcreteTextureCoordinates[2]=0.0f;
        ConcreteTextureCoordinates[3]=0.0f;
        //Vertex3
        ConcreteTextureCoordinates[4]=0.0f;
        ConcreteTextureCoordinates[5]=1.0f;

        //TRIANGLE 2
        //Vertex1
        ConcreteTextureCoordinates[6]=1.0f;
        ConcreteTextureCoordinates[7]=0.0f;
        //Vertex2
        ConcreteTextureCoordinates[8]=0.0f;
        ConcreteTextureCoordinates[9]=1.0f;
        //Vertex3
        ConcreteTextureCoordinates[10]=1.0f;
        ConcreteTextureCoordinates[11]=1.0f;

        //TRIANGLE 3
        //Vertex1
        ConcreteTextureCoordinates[12]=0.0f;
        ConcreteTextureCoordinates[13]=1.0f;
        //Vertex2
        ConcreteTextureCoordinates[14]=0.0f;
        ConcreteTextureCoordinates[15]=0.0f;
        //Vertex3
        ConcreteTextureCoordinates[16]=hl*1.0f;
        ConcreteTextureCoordinates[17]=0.0f;

        //TRIANGLE 4
        //Vertex1
        ConcreteTextureCoordinates[18]=0.0f;
        ConcreteTextureCoordinates[19]=1.0f;
        //Vertex2
        ConcreteTextureCoordinates[20]=hl*1.0f;
        ConcreteTextureCoordinates[21]=0.0f;
        //Vertex3
        ConcreteTextureCoordinates[22]=hl*1.0f;
        ConcreteTextureCoordinates[23]=1.0f;

        //TRIANGLE 5
        //Vertex1
        ConcreteTextureCoordinates[24]=0.0f;
        ConcreteTextureCoordinates[25]=0.0f;
        //Vertex2
        ConcreteTextureCoordinates[26]=0.0f;
        ConcreteTextureCoordinates[27]=1.0f;
        //Vertex3
        ConcreteTextureCoordinates[28]=1.0f;
        ConcreteTextureCoordinates[29]=1.0f;

        //TRIANGLE 6
        //Vertex1
        ConcreteTextureCoordinates[30]=0.0f;
        ConcreteTextureCoordinates[31]=0.0f;
        //Vertex2
        ConcreteTextureCoordinates[32]=1.0f;
        ConcreteTextureCoordinates[33]=1.0f;
        //Vertex3
        ConcreteTextureCoordinates[34]=1.0f;
        ConcreteTextureCoordinates[35]=0.0f;

        //TRIANGLE 7
        //Vertex1
        ConcreteTextureCoordinates[36]=0.0f;
        ConcreteTextureCoordinates[37]=0.0f;
        //Vertex2
        ConcreteTextureCoordinates[38]=0.0f;
        ConcreteTextureCoordinates[39]=1.0f;
        //Vertex3
        ConcreteTextureCoordinates[40]=hl*1.0f;
        ConcreteTextureCoordinates[41]=0.0f;

        //TRIANGLE 8
        //Vertex1
        ConcreteTextureCoordinates[42]=0.0f;
        ConcreteTextureCoordinates[43]=1.0f;
        //Vertex2
        ConcreteTextureCoordinates[44]=hl*1.0f;
        ConcreteTextureCoordinates[45]=1.0f;
        //Vertex3
        ConcreteTextureCoordinates[46]=hl*1.0f;
        ConcreteTextureCoordinates[47]=0.0f;

        //TRIANGLE 9
        //Vertex1
        ConcreteTextureCoordinates[48]=0.0f;
        ConcreteTextureCoordinates[49]=hb*1.0f;
        //Vertex2
        ConcreteTextureCoordinates[50]=hl*1.0f;
        ConcreteTextureCoordinates[51]=hb*1.0f;
        //Vertex3
        ConcreteTextureCoordinates[52]=0.0f;
        ConcreteTextureCoordinates[53]=0.0f;

        //TRIANGLE 10
        //Vertex1
        ConcreteTextureCoordinates[54]=0.0f;
        ConcreteTextureCoordinates[55]=0.0f;
        //Vertex2
        ConcreteTextureCoordinates[56]=hl*1.0f;
        ConcreteTextureCoordinates[57]=hb*1.0f;
        //Vertex3
        ConcreteTextureCoordinates[58]=hl*1.0f;
        ConcreteTextureCoordinates[59]=0.0f;

        //TRIANGLE 11
        //Vertex1
        ConcreteTextureCoordinates[60]=hl*1.0f;
        ConcreteTextureCoordinates[61]=0.0f;
        //Vertex2
        ConcreteTextureCoordinates[62]=hl*1.0f;
        ConcreteTextureCoordinates[63]=hb*1.0f;
        //Vertex3
        ConcreteTextureCoordinates[64]=0.0f;
        ConcreteTextureCoordinates[65]=0.0f;

        //TRIANGLE 12
        //Vertex1
        ConcreteTextureCoordinates[66]=hl*1.0f;
        ConcreteTextureCoordinates[67]=hb*1.0f;
        //Vertex2
        ConcreteTextureCoordinates[68]=0.0f;
        ConcreteTextureCoordinates[69]=hb*1.0f;
        //Vertex3
        ConcreteTextureCoordinates[70]=0.0f;
        ConcreteTextureCoordinates[71]=0.0f;
    }
}
