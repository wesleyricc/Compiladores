/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wesley Ricardo
 */
public class Parsing {
    
    private Integer tabParsing[][] = new Integer[77][48];

    public Parsing() {

        tabParsing[48][2] = 1;
        tabParsing[49][2] = 3;
        tabParsing[49][3] = 3;
        tabParsing[49][7] = 2;
        tabParsing[49][12] = 3;
        tabParsing[49][13] = 3;
        tabParsing[49][17] = 3;
        tabParsing[49][23] = 3;
        tabParsing[49][44] = 3;
        tabParsing[50][2] = 13;
        tabParsing[50][3] = 13;
        tabParsing[50][12] = 13;
        tabParsing[50][13] = 19;
        tabParsing[50][17] = 13;
        tabParsing[50][23] = 13;
        tabParsing[51][13] = 31;
        tabParsing[52][38] = 4;
        tabParsing[52][40] = 5;
        tabParsing[53][3] = 8;
        tabParsing[53][12] = 6;
        tabParsing[53][17] = 7;
        tabParsing[53][23] = 9;
        tabParsing[54][2] = 10;
        tabParsing[54][3] = 10;
        tabParsing[54][7] = 11;
        tabParsing[54][12] = 10;
        tabParsing[54][13] = 10;
        tabParsing[54][17] = 10;
        tabParsing[54][23] = 10;
        tabParsing[54][44] = 10;
        tabParsing[55][7] = 12;
        tabParsing[56][2] = 15;
        tabParsing[56][3] = 18;
        tabParsing[56][12] = 14;
        tabParsing[56][17] = 17;
        tabParsing[56][23] = 16;
        tabParsing[57][36] = 26;
        tabParsing[57][43] = 27;
        tabParsing[58][5] = 20;
        tabParsing[58][6] = 21;
        tabParsing[58][7] = 22;
        tabParsing[58][8] = 23;
        tabParsing[58][9] = 24;
        tabParsing[58][42] = 25;
        tabParsing[59][3] = 28;
        tabParsing[59][12] = 28;
        tabParsing[59][17] = 28;
        tabParsing[59][23] = 28;
        tabParsing[60][37] = 29;
        tabParsing[60][42] = 30;
        tabParsing[61][1] = 52;
        tabParsing[61][5] = 37;
        tabParsing[61][6] = 37;
        tabParsing[61][7] = 37;
        tabParsing[61][8] = 37;
        tabParsing[61][9] = 37;
        tabParsing[61][14] = 49;
        tabParsing[61][16] = 64;
        tabParsing[61][20] = 67;
        tabParsing[61][21] = 69;
        tabParsing[61][22] = 68;
        tabParsing[61][24] = 39;
        tabParsing[61][37] = 38;
        tabParsing[61][43] = 37;
        tabParsing[62][18] = 32;
        //tabParsing[62][21] = 32; //modificada
        tabParsing[62][35] = 32;//modificada
        //tabParsing[62][35] = 33;
        tabParsing[63][5] = 75;
        tabParsing[63][6] = 75;
        tabParsing[63][7] = 75;
        tabParsing[63][8] = 75;
        tabParsing[63][9] = 75;
        tabParsing[63][24] = 76;
        tabParsing[63][43] = 75;
        tabParsing[64][29] = 40;
        tabParsing[64][37] = 40;
        tabParsing[64][42] = 40;
        tabParsing[64][43] = 41;
        tabParsing[65][5] = 44;
        tabParsing[65][6] = 46;
        tabParsing[65][7] = 48;
        tabParsing[65][8] = 47;
        tabParsing[65][9] = 45;
        tabParsing[66][40] = 43;
        tabParsing[66][42] = 42;
        //tabParsing[66][7] =  ????
        tabParsing[67][26] = 56;
        tabParsing[67][27] = 55;
        tabParsing[67][28] = 53;
        tabParsing[67][30] = 58;
        tabParsing[67][32] = 57;
        tabParsing[67][45] = 54;
        tabParsing[68][19] = 50;
        tabParsing[68][37] = 51;
        tabParsing[69][5] = 59;
        tabParsing[69][6] = 60;
        tabParsing[69][7] = 63;
        tabParsing[69][8] = 62;
        tabParsing[69][9] = 61;
        tabParsing[70][33] = 65;
        tabParsing[70][46] = 66;
        tabParsing[71][31] = 72;
        tabParsing[71][37] = 70;
        tabParsing[72][31] = 73;
        tabParsing[72][37] = 73;
        tabParsing[72][40] = 74;
        tabParsing[73][5] = 80;
        tabParsing[73][6] = 80;
        tabParsing[73][7] = 80;
        tabParsing[73][8] = 80;
        tabParsing[73][9] = 80;
        tabParsing[73][43] = 80;
        tabParsing[74][29] = 79;
        tabParsing[74][34] = 77;
        tabParsing[74][37] = 79;
        tabParsing[74][42] = 79;
        tabParsing[74][47] = 78;
        tabParsing[75][5] = 84;
        tabParsing[75][6] = 85;
        tabParsing[75][7] = 86;
        tabParsing[75][8] = 88;
        tabParsing[75][9] = 87;
        tabParsing[75][43] = 89;
        tabParsing[76][29] = 81;
        tabParsing[76][34] = 81;
        tabParsing[76][37] = 81;
        tabParsing[76][39] = 83;
        tabParsing[76][41] = 82;
        tabParsing[76][42] = 81;
        tabParsing[76][47] = 81;

    }
      
    public Integer[][] getParsing(){
        
        return tabParsing;
        
    }

}


