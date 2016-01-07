package com.manolovn.colorbrewer;

import android.graphics.Color;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * The data values were extracted from the RColorBrewer R package.
 * See http://www.datavis.ca/sas/macros/color/brewer.sas
 */
public enum ColorBrewer {
    BrBG(1, "Brown-Blue-Green", true, new String[][]{
            {"D8B365" },
            {"D8B365", "5AB4AC" },
            {"D8B365", "F5F5F5", "5AB4AC" },
            {"A6611A", "DFC27D", "80CDC1", "018571" },
            {"A6611A", "DFC27D", "F5F5F5", "80CDC1", "018571" },
            {"8C510A", "D8B365", "F6E8C3", "C7EAE5", "5AB4AC", "01665E" },
            {"8C510A", "D8B365", "F6E8C3", "F5F5F5", "C7EAE5", "5AB4AC", "01665E" },
            {"8C510A", "BF812D", "DFC27D", "F6E8C3", "C7EAE5", "80CDC1", "35978F", "01665E" },
            {"8C510A", "BF812D", "DFC27D", "F6E8C3", "F5F5F5", "C7EAE5", "80CDC1", "35978F", "01665E" },
            {"543005", "8C510A", "BF812D", "DFC27D", "F6E8C3", "C7EAE5", "80CDC1", "35978F", "01665E", "003C30" },
            {"543005", "8C510A", "BF812D", "DFC27D", "F6E8C3", "F5F5F5", "C7EAE5", "80CDC1", "35978F", "01665E", "003C30" }
    }),
    PiYG(1, "Magenta-Yellow-Green", true, new String[][]{
            {"E9A3C9" },
            {"E9A3C9", "A1D76A" },
            {"E9A3C9", "F7F7F7", "A1D76A" },
            {"D01C8B", "F1B6DA", "B8E186", "4DAC26" },
            {"D01C8B", "F1B6DA", "F7F7F7", "B8E186", "4DAC26" },
            {"C51B7D", "E9A3C9", "FDE0EF", "E6F5D0", "A1D76A", "4D9221" },
            {"C51B7D", "E9A3C9", "FDE0EF", "F7F7F7", "E6F5D0", "A1D76A", "4D9221" },
            {"C51B7D", "DE77AE", "F1B6DA", "FDE0EF", "E6F5D0", "B8E186", "7FBC41", "4D9221" },
            {"C51B7D", "DE77AE", "F1B6DA", "FDE0EF", "F7F7F7", "E6F5D0", "B8E186", "7FBC41", "4D9221" },
            {"8E0152", "C51B7D", "DE77AE", "F1B6DA", "FDE0EF", "E6F5D0", "B8E186", "7FBC41", "4D9221", "276419" },
            {"8E0152", "C51B7D", "DE77AE", "F1B6DA", "FDE0EF", "F7F7F7", "E6F5D0", "B8E186", "7FBC41", "4D9221", "276419" }
    }),
    PRGn(1, "Purple-Red-Green", true, new String[][]{
            {"AF8DC3" },
            {"AF8DC3", "7FBF7B" },
            {"AF8DC3", "F7F7F7", "7FBF7B" },
            {"7B3294", "C2A5CF", "A6DBA0", "008837" },
            {"7B3294", "C2A5CF", "F7F7F7", "A6DBA0", "008837" },
            {"762A83", "AF8DC3", "E7D4E8", "D9F0D3", "7FBF7B", "1B7837" },
            {"762A83", "AF8DC3", "E7D4E8", "F7F7F7", "D9F0D3", "7FBF7B", "1B7837" },
            {"762A83", "9970AB", "C2A5CF", "E7D4E8", "D9F0D3", "A6DBA0", "5AAE61", "1B7837" },
            {"762A83", "9970AB", "C2A5CF", "E7D4E8", "F7F7F7", "D9F0D3", "A6DBA0", "5AAE61", "1B7837" },
            {"40004B", "762A83", "9970AB", "C2A5CF", "E7D4E8", "D9F0D3", "A6DBA0", "5AAE61", "1B7837", "00441B" },
            {"40004B", "762A83", "9970AB", "C2A5CF", "E7D4E8", "F7F7F7", "D9F0D3", "A6DBA0", "5AAE61", "1B7837", "00441B" }
    }),
    PuOr(1, "Purple-Orange", true, new String[][]{
            {"F1A340" },
            {"F1A340", "998EC3" },
            {"F1A340", "F7F7F7", "998EC3" },
            {"E66101", "FDB863", "B2ABD2", "5E3C99" },
            {"E66101", "FDB863", "F7F7F7", "B2ABD2", "5E3C99" },
            {"B35806", "F1A340", "FEE0B6", "D8DAEB", "998EC3", "542788" },
            {"B35806", "F1A340", "FEE0B6", "F7F7F7", "D8DAEB", "998EC3", "542788" },
            {"B35806", "E08214", "FDB863", "FEE0B6", "D8DAEB", "B2ABD2", "8073AC", "542788" },
            {"B35806", "E08214", "FDB863", "FEE0B6", "F7F7F7", "D8DAEB", "B2ABD2", "8073AC", "542788" },
            {"7F3B08", "B35806", "E08214", "FDB863", "FEE0B6", "D8DAEB", "B2ABD2", "8073AC", "542788", "2D004B" },
            {"7F3B08", "B35806", "E08214", "FDB863", "FEE0B6", "F7F7F7", "D8DAEB", "B2ABD2", "8073AC", "542788", "2D004B" }
    }),
    RdBu(1, "Red-Blue", true, new String[][]{
            {"EF8A62" },
            {"EF8A62", "67A9CF" },
            {"EF8A62", "F7F7F7", "67A9CF" },
            {"CA0020", "F4A582", "92C5DE", "0571B0" },
            {"CA0020", "F4A582", "F7F7F7", "92C5DE", "0571B0" },
            {"B2182B", "EF8A62", "FDDBC7", "D1E5F0", "67A9CF", "2166AC" },
            {"B2182B", "EF8A62", "FDDBC7", "F7F7F7", "D1E5F0", "67A9CF", "2166AC" },
            {"B2182B", "D6604D", "F4A582", "FDDBC7", "D1E5F0", "92C5DE", "4393C3", "2166AC" },
            {"B2182B", "D6604D", "F4A582", "FDDBC7", "F7F7F7", "D1E5F0", "92C5DE", "4393C3", "2166AC" },
            {"67001F", "B2182B", "D6604D", "F4A582", "FDDBC7", "D1E5F0", "92C5DE", "4393C3", "2166AC", "053061" },
            {"67001F", "B2182B", "D6604D", "F4A582", "FDDBC7", "F7F7F7", "D1E5F0", "92C5DE", "4393C3", "2166AC", "053061" }
    }),
    RdGy(1, "Red-Grey", false, new String[][]{
            {"EF8A62" },
            {"EF8A62", "999999" },
            {"EF8A62", "FFFFFF", "999999" },
            {"CA0020", "F4A582", "BABABA", "404040" },
            {"CA0020", "F4A582", "FFFFFF", "BABABA", "404040" },
            {"B2182B", "EF8A62", "FDDBC7", "E0E0E0", "999999", "4D4D4D" },
            {"B2182B", "EF8A62", "FDDBC7", "FFFFFF", "E0E0E0", "999999", "4D4D4D" },
            {"B2182B", "D6604D", "F4A582", "FDDBC7", "E0E0E0", "BABABA", "878787", "4D4D4D" },
            {"B2182B", "D6604D", "F4A582", "FDDBC7", "FFFFFF", "E0E0E0", "BABABA", "878787", "4D4D4D" },
            {"67001F", "B2182B", "D6604D", "F4A582", "FDDBC7", "E0E0E0", "BABABA", "878787", "4D4D4D", "1A1A1A" },
            {"67001F", "B2182B", "D6604D", "F4A582", "FDDBC7", "FFFFFF", "E0E0E0", "BABABA", "878787", "4D4D4D", "1A1A1A" }
    }),
    RdYlBu(1, "Red-Yellow-Blue", true, new String[][]{
            {"FC8D59" },
            {"FC8D59", "91BFDB" },
            {"FC8D59", "FFFFBF", "91BFDB" },
            {"D7191C", "FDAE61", "ABD9E9", "2C7BB6" },
            {"D7191C", "FDAE61", "FFFFBF", "ABD9E9", "2C7BB6" },
            {"D73027", "FC8D59", "FEE090", "E0F3F8", "91BFDB", "4575B4" },
            {"D73027", "FC8D59", "FEE090", "FFFFBF", "E0F3F8", "91BFDB", "4575B4" },
            {"D73027", "F46D43", "FDAE61", "FEE090", "E0F3F8", "ABD9E9", "74ADD1", "4575B4" },
            {"D73027", "F46D43", "FDAE61", "FEE090", "FFFFBF", "E0F3F8", "ABD9E9", "74ADD1", "4575B4" },
            {"A50026", "D73027", "F46D43", "FDAE61", "FEE090", "E0F3F8", "ABD9E9", "74ADD1", "4575B4", "313695" },
            {"A50026", "D73027", "F46D43", "FDAE61", "FEE090", "FFFFBF", "E0F3F8", "ABD9E9", "74ADD1", "4575B4", "313695" }
    }),
    RdYlGn(1, "Red-Yellow-Green", false, new String[][]{
            {"FC8D59" },
            {"FC8D59", "91CF60" },
            {"FC8D59", "FFFFBF", "91CF60" },
            {"D7191C", "FDAE61", "A6D96A", "1A9641" },
            {"D7191C", "FDAE61", "FFFFBF", "A6D96A", "1A9641" },
            {"D73027", "FC8D59", "FEE08B", "D9EF8B", "91CF60", "1A9850" },
            {"D73027", "FC8D59", "FEE08B", "FFFFBF", "D9EF8B", "91CF60", "1A9850" },
            {"D73027", "F46D43", "FDAE61", "FEE08B", "D9EF8B", "A6D96A", "66BD63", "1A9850" },
            {"D73027", "F46D43", "FDAE61", "FEE08B", "FFFFBF", "D9EF8B", "A6D96A", "66BD63", "1A9850" },
            {"A50026", "D73027", "F46D43", "FDAE61", "FEE08B", "D9EF8B", "A6D96A", "66BD63", "1A9850", "006837" },
            {"A50026", "D73027", "F46D43", "FDAE61", "FEE08B", "FFFFBF", "D9EF8B", "A6D96A", "66BD63", "1A9850", "006837" }
    }),
    Spectral(1, "Spectral colors", false, new String[][]{
            {"FC8D59" },
            {"FC8D59", "99D594" },
            {"FC8D59", "FFFFBF", "99D594" },
            {"D7191C", "FDAE61", "ABDDA4", "2B83BA" },
            {"D7191C", "FDAE61", "FFFFBF", "ABDDA4", "2B83BA" },
            {"D53E4F", "FC8D59", "FEE08B", "E6F598", "99D594", "3288BD" },
            {"D53E4F", "FC8D59", "FEE08B", "FFFFBF", "E6F598", "99D594", "3288BD" },
            {"D53E4F", "F46D43", "FDAE61", "FEE08B", "E6F598", "ABDDA4", "66C2A5", "3288BD" },
            {"D53E4F", "F46D43", "FDAE61", "FEE08B", "FFFFBF", "E6F598", "ABDDA4", "66C2A5", "3288BD" },
            {"9E0142", "D53E4F", "F46D43", "FDAE61", "FEE08B", "E6F598", "ABDDA4", "66C2A5", "3288BD", "5E4FA2" },
            {"9E0142", "D53E4F", "F46D43", "FDAE61", "FEE08B", "FFFFBF", "E6F598", "ABDDA4", "66C2A5", "3288BD", "5E4FA2" }
    }),
    /* qualitative colors */
    Accent(2, "Accents", false, new String[][]{
            {"7FC97F" },
            {"7FC97F", "FDC086" },
            {"7FC97F", "BEAED4", "FDC086" },
            {"7FC97F", "BEAED4", "FDC086", "FFFF99" },
            {"7FC97F", "BEAED4", "FDC086", "FFFF99", "386CB0" },
            {"7FC97F", "BEAED4", "FDC086", "FFFF99", "386CB0", "F0027F" },
            {"7FC97F", "BEAED4", "FDC086", "FFFF99", "386CB0", "F0027F", "BF5B17" },
            {"7FC97F", "BEAED4", "FDC086", "FFFF99", "386CB0", "F0027F", "BF5B17", "666666" }
    }),
    Dark2(2, "Dark colors", false, new String[][]{
            {"1B9E77" },
            {"1B9E77", "7570B3" },
            {"1B9E77", "D95F02", "7570B3" },
            {"1B9E77", "D95F02", "7570B3", "E7298A" },
            {"1B9E77", "D95F02", "7570B3", "E7298A", "66A61E" },
            {"1B9E77", "D95F02", "7570B3", "E7298A", "66A61E", "E6AB02" },
            {"1B9E77", "D95F02", "7570B3", "E7298A", "66A61E", "E6AB02", "A6761D" },
            {"1B9E77", "D95F02", "7570B3", "E7298A", "66A61E", "E6AB02", "A6761D", "666666" }
    }),
    Paired(2, "Paired colors", true, new String[][]{
            {"A6CEE3" },
            {"A6CEE3", "B2DF8A" },
            {"A6CEE3", "1F78B4", "B2DF8A" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C", "FB9A99" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C", "FB9A99", "E31A1C" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C", "FB9A99", "E31A1C", "FDBF6F" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C", "FB9A99", "E31A1C", "FDBF6F", "FF7F00" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C", "FB9A99", "E31A1C", "FDBF6F", "FF7F00", "CAB2D6" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C", "FB9A99", "E31A1C", "FDBF6F", "FF7F00", "CAB2D6", "6A3D9A" },
            {"A6CEE3", "1F78B4", "B2DF8A", "33A02C", "FB9A99", "E31A1C", "FDBF6F", "FF7F00", "CAB2D6", "6A3D9A", "FFFF99" }
    }),
    Pastel1(2, "Pastel1 colors", false, new String[][]{
            {"FBB4AE" },
            {"FBB4AE", "CCEBC5" },
            {"FBB4AE", "B3CDE3", "CCEBC5" },
            {"FBB4AE", "B3CDE3", "CCEBC5", "DECBE4" },
            {"FBB4AE", "B3CDE3", "CCEBC5", "DECBE4", "FED9A6" },
            {"FBB4AE", "B3CDE3", "CCEBC5", "DECBE4", "FED9A6", "FFFFCC" },
            {"FBB4AE", "B3CDE3", "CCEBC5", "DECBE4", "FED9A6", "FFFFCC", "E5D8BD" },
            {"FBB4AE", "B3CDE3", "CCEBC5", "DECBE4", "FED9A6", "FFFFCC", "E5D8BD", "FDDAEC" },
            {"FBB4AE", "B3CDE3", "CCEBC5", "DECBE4", "FED9A6", "FFFFCC", "E5D8BD", "FDDAEC", "F2F2F2" }
    }),
    Pastel2(2, "Pastel2 colors", false, new String[][]{
            {"B3E2CD" },
            {"B3E2CD", "CBD5E8" },
            {"B3E2CD", "FDCDAC", "CBD5E8" },
            {"B3E2CD", "FDCDAC", "CBD5E8", "F4CAE4" },
            {"B3E2CD", "FDCDAC", "CBD5E8", "F4CAE4", "E6F5C9" },
            {"B3E2CD", "FDCDAC", "CBD5E8", "F4CAE4", "E6F5C9", "FFF2AE" },
            {"B3E2CD", "FDCDAC", "CBD5E8", "F4CAE4", "E6F5C9", "FFF2AE", "F1E2CC" },
            {"B3E2CD", "FDCDAC", "CBD5E8", "F4CAE4", "E6F5C9", "FFF2AE", "F1E2CC", "CCCCCC" }
    }),
    Set1(2, "Set1 colors", false, new String[][]{
            {"E41A1C" },
            {"E41A1C", "4DAF4A" },
            {"E41A1C", "377EB8", "4DAF4A" },
            {"E41A1C", "377EB8", "4DAF4A", "984EA3" },
            {"E41A1C", "377EB8", "4DAF4A", "984EA3", "FF7F00" },
            {"E41A1C", "377EB8", "4DAF4A", "984EA3", "FF7F00", "FFFF33" },
            {"E41A1C", "377EB8", "4DAF4A", "984EA3", "FF7F00", "FFFF33", "A65628" },
            {"E41A1C", "377EB8", "4DAF4A", "984EA3", "FF7F00", "FFFF33", "A65628", "F781BF" },
            {"E41A1C", "377EB8", "4DAF4A", "984EA3", "FF7F00", "FFFF33", "A65628", "F781BF", "999999" }
    }),
    Set2(2, "Set2 colors", false, new String[][]{
            {"66C2A5" },
            {"66C2A5", "8DA0CB" },
            {"66C2A5", "FC8D62", "8DA0CB" },
            {"66C2A5", "FC8D62", "8DA0CB", "E78AC3" },
            {"66C2A5", "FC8D62", "8DA0CB", "E78AC3", "A6D854" },
            {"66C2A5", "FC8D62", "8DA0CB", "E78AC3", "A6D854", "FFD92F" },
            {"66C2A5", "FC8D62", "8DA0CB", "E78AC3", "A6D854", "FFD92F", "E5C494" },
            {"66C2A5", "FC8D62", "8DA0CB", "E78AC3", "A6D854", "FFD92F", "E5C494", "B3B3B" }
    }),
    Set3(2, "Set3 colors", false, new String[][]{
            {"8DD3C7" },
            {"8DD3C7", "BEBADA" },
            {"8DD3C7", "FFFFB3", "BEBADA" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072", "80B1D3" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072", "80B1D3", "FDB462" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072", "80B1D3", "FDB462", "B3DE69" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072", "80B1D3", "FDB462", "B3DE69", "FCCDE5" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072", "80B1D3", "FDB462", "B3DE69", "FCCDE5", "D9D9D9" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072", "80B1D3", "FDB462", "B3DE69", "FCCDE5", "D9D9D9", "BC80BD" },
            {"8DD3C7", "FFFFB3", "BEBADA", "FB8072", "80B1D3", "FDB462", "B3DE69", "FCCDE5", "D9D9D9", "BC80BD", "CCEBC5" }
    }),
    /* sequential colors */
    Blues(3, "Blue shades", true, new String[][]{
            {"DEEBF7" },
            {"DEEBF7", "3182BD" },
            {"DEEBF7", "9ECAE1", "3182BD" },
            {"EFF3FF", "BDD7E7", "6BAED6", "2171B5" },
            {"EFF3FF", "BDD7E7", "6BAED6", "3182BD", "08519C" },
            {"EFF3FF", "C6DBEF", "9ECAE1", "6BAED6", "3182BD", "08519C" },
            {"EFF3FF", "C6DBEF", "9ECAE1", "6BAED6", "4292C6", "2171B5", "084594" },
            {"F7FBFF", "DEEBF7", "C6DBEF", "9ECAE1", "6BAED6", "4292C6", "2171B5", "084594" },
            {"F7FBFF", "DEEBF7", "C6DBEF", "9ECAE1", "6BAED6", "4292C6", "2171B5", "08519C", "08306B" }
    }),
    BuGn(3, "Blue-Green shades", true, new String[][]{
            {"E5F5F9" },
            {"E5F5F9", "2CA25F" },
            {"E5F5F9", "99D8C9", "2CA25F" },
            {"EDF8FB", "B2E2E2", "66C2A4", "238B45" },
            {"EDF8FB", "B2E2E2", "66C2A4", "2CA25F", "006D2C" },
            {"EDF8FB", "CCECE6", "99D8C9", "66C2A4", "2CA25F", "006D2C" },
            {"EDF8FB", "CCECE6", "99D8C9", "66C2A4", "41AE76", "238B45", "005824" },
            {"F7FCFD", "E5F5F9", "CCECE6", "99D8C9", "66C2A4", "41AE76", "238B45", "005824" },
            {"F7FCFD", "E5F5F9", "CCECE6", "99D8C9", "66C2A4", "41AE76", "238B45", "006D2C", "00441B" }
    }),
    BuPu(3, "Blue-Purple shades", true, new String[][]{
            {"E0ECF4" },
            {"E0ECF4", "8856A7" },
            {"E0ECF4", "9EBCDA", "8856A7" },
            {"EDF8FB", "B3CDE3", "8C96C6", "88419D" },
            {"EDF8FB", "B3CDE3", "8C96C6", "8856A7", "810F7C" },
            {"EDF8FB", "BFD3E6", "9EBCDA", "8C96C6", "8856A7", "810F7C" },
            {"EDF8FB", "BFD3E6", "9EBCDA", "8C96C6", "8C6BB1", "88419D", "6E016B" },
            {"F7FCFD", "E0ECF4", "BFD3E6", "9EBCDA", "8C96C6", "8C6BB1", "88419D", "6E016B" },
            {"F7FCFD", "E0ECF4", "BFD3E6", "9EBCDA", "8C96C6", "8C6BB1", "88419D", "810F7C", "4D004B" }
    }),
    GnBu(3, "Green-Blue shades", true, new String[][]{
            {"E0F3DB" },
            {"E0F3DB", "43A2CA" },
            {"E0F3DB", "A8DDB5", "43A2CA" },
            {"F0F9E8", "BAE4BC", "7BCCC4", "2B8CBE" },
            {"F0F9E8", "BAE4BC", "7BCCC4", "43A2CA", "0868AC" },
            {"F0F9E8", "CCEBC5", "A8DDB5", "7BCCC4", "43A2CA", "0868AC" },
            {"F0F9E8", "CCEBC5", "A8DDB5", "7BCCC4", "4EB3D3", "2B8CBE", "08589E" },
            {"F7FCF0", "E0F3DB", "CCEBC5", "A8DDB5", "7BCCC4", "4EB3D3", "2B8CBE", "08589E" },
            {"F7FCF0", "E0F3DB", "CCEBC5", "A8DDB5", "7BCCC4", "4EB3D3", "2B8CBE", "0868AC", "084081" }
    }),
    Greens(3, "Green shades", true, new String[][]{
            {"E5F5E0" },
            {"E5F5E0", "31A354" },
            {"E5F5E0", "A1D99B", "31A354" },
            {"EDF8E9", "BAE4B3", "74C476", "238B45" },
            {"EDF8E9", "BAE4B3", "74C476", "31A354", "006D2C" },
            {"EDF8E9", "C7E9C0", "A1D99B", "74C476", "31A354", "006D2C" },
            {"EDF8E9", "C7E9C0", "A1D99B", "74C476", "41AB5D", "238B45", "005A32" },
            {"F7FCF5", "E5F5E0", "C7E9C0", "A1D99B", "74C476", "41AB5D", "238B45", "005A32" },
            {"F7FCF5", "E5F5E0", "C7E9C0", "A1D99B", "74C476", "41AB5D", "238B45", "006D2C", "00441B" }
    }),
    Greys(3, "Grey shades", true, new String[][]{
            {"F0F0F0" },
            {"F0F0F0", "636363" },
            {"F0F0F0", "BDBDBD", "636363" },
            {"F7F7F7", "CCCCCC", "969696", "525252" },
            {"F7F7F7", "CCCCCC", "969696", "636363", "252525" },
            {"F7F7F7", "D9D9D9", "BDBDBD", "969696", "636363", "252525" },
            {"F7F7F7", "D9D9D9", "BDBDBD", "969696", "737373", "525252", "252525" },
            {"FFFFFF", "F0F0F0", "D9D9D9", "BDBDBD", "969696", "737373", "525252", "252525" },
            {"FFFFFF", "F0F0F0", "D9D9D9", "BDBDBD", "969696", "737373", "525252", "252525", "000000" }
    }),
    Oranges(3, "Orange shades", true, new String[][]{
            {"FEE6CE" },
            {"FEE6CE", "E6550D" },
            {"FEE6CE", "FDAE6B", "E6550D" },
            {"FEEDDE", "FDBE85", "FD8D3C", "D94701" },
            {"FEEDDE", "FDBE85", "FD8D3C", "E6550D", "A63603" },
            {"FEEDDE", "FDD0A2", "FDAE6B", "FD8D3C", "E6550D", "A63603" },
            {"FEEDDE", "FDD0A2", "FDAE6B", "FD8D3C", "F16913", "D94801", "8C2D04" },
            {"FFF5EB", "FEE6CE", "FDD0A2", "FDAE6B", "FD8D3C", "F16913", "D94801", "8C2D04" },
            {"FFF5EB", "FEE6CE", "FDD0A2", "FDAE6B", "FD8D3C", "F16913", "D94801", "A63603", "7F2704" }
    }),
    OrRd(3, "Orange-Red shades", true, new String[][]{
            {"FEE8C8" },
            {"FEE8C8", "E34A33" },
            {"FEE8C8", "FDBB84", "E34A33" },
            {"FEF0D9", "FDCC8A", "FC8D59", "D7301F" },
            {"FEF0D9", "FDCC8A", "FC8D59", "E34A33", "B30000" },
            {"FEF0D9", "FDD49E", "FDBB84", "FC8D59", "E34A33", "B30000" },
            {"FEF0D9", "FDD49E", "FDBB84", "FC8D59", "EF6548", "D7301F", "990000" },
            {"FFF7EC", "FEE8C8", "FDD49E", "FDBB84", "FC8D59", "EF6548", "D7301F", "990000" },
            {"FFF7EC", "FEE8C8", "FDD49E", "FDBB84", "FC8D59", "EF6548", "D7301F", "B30000", "7F0000" }
    }),
    PuBu(3, "Purple-Blue shades", true, new String[][]{
            {"ECE7F2" },
            {"ECE7F2", "2B8CBE" },
            {"ECE7F2", "A6BDDB", "2B8CBE" },
            {"F1EEF6", "BDC9E1", "74A9CF", "0570B0" },
            {"F1EEF6", "BDC9E1", "74A9CF", "2B8CBE", "045A8D" },
            {"F1EEF6", "D0D1E6", "A6BDDB", "74A9CF", "2B8CBE", "045A8D" },
            {"F1EEF6", "D0D1E6", "A6BDDB", "74A9CF", "3690C0", "0570B0", "034E7B" },
            {"FFF7FB", "ECE7F2", "D0D1E6", "A6BDDB", "74A9CF", "3690C0", "0570B0", "034E7B" },
            {"FFF7FB", "ECE7F2", "D0D1E6", "A6BDDB", "74A9CF", "3690C0", "0570B0", "045A8D", "023858" }
    }),
    PuBuGn(3, "Purple-Blue-Green shades", true, new String[][]{
            {"ECE2F0" },
            {"ECE2F0", "1C9099" },
            {"ECE2F0", "A6BDDB", "1C9099" },
            {"F6EFF7", "BDC9E1", "67A9CF", "02818A" },
            {"F6EFF7", "BDC9E1", "67A9CF", "1C9099", "016C59" },
            {"F6EFF7", "D0D1E6", "A6BDDB", "67A9CF", "1C9099", "016C59" },
            {"F6EFF7", "D0D1E6", "A6BDDB", "67A9CF", "3690C0", "02818A", "016450" },
            {"FFF7FB", "ECE2F0", "D0D1E6", "A6BDDB", "67A9CF", "3690C0", "02818A", "016450" },
            {"FFF7FB", "ECE2F0", "D0D1E6", "A6BDDB", "67A9CF", "3690C0", "02818A", "016C59", "014636" }
    }),
    PuRd(3, "Purple-Red shades", true, new String[][]{
            {"E7E1EF" },
            {"E7E1EF", "DD1C77" },
            {"E7E1EF", "C994C7", "DD1C77" },
            {"F1EEF6", "D7B5D8", "DF65B0", "CE1256" },
            {"F1EEF6", "D7B5D8", "DF65B0", "DD1C77", "980043" },
            {"F1EEF6", "D4B9DA", "C994C7", "DF65B0", "DD1C77", "980043" },
            {"F1EEF6", "D4B9DA", "C994C7", "DF65B0", "E7298A", "CE1256", "91003F" },
            {"F7F4F9", "E7E1EF", "D4B9DA", "C994C7", "DF65B0", "E7298A", "CE1256", "91003F" },
            {"F7F4F9", "E7E1EF", "D4B9DA", "C994C7", "DF65B0", "E7298A", "CE1256", "980043", "67001F" }
    }),
    Purples(3, "Purple shades", true, new String[][]{
            {"EFEDF5" },
            {"EFEDF5", "756BB1" },
            {"EFEDF5", "BCBDDC", "756BB1" },
            {"F2F0F7", "CBC9E2", "9E9AC8", "6A51A3" },
            {"F2F0F7", "CBC9E2", "9E9AC8", "756BB1", "54278F" },
            {"F2F0F7", "DADAEB", "BCBDDC", "9E9AC8", "756BB1", "54278F" },
            {"F2F0F7", "DADAEB", "BCBDDC", "9E9AC8", "807DBA", "6A51A3", "4A1486" },
            {"FCFBFD", "EFEDF5", "DADAEB", "BCBDDC", "9E9AC8", "807DBA", "6A51A3", "4A1486" },
            {"FCFBFD", "EFEDF5", "DADAEB", "BCBDDC", "9E9AC8", "807DBA", "6A51A3", "54278F", "3F007D" },
    }),
    RdPu(3, "Red-Purple shades", true, new String[][]{
            {"FDE0DD" },
            {"FDE0DD", "C51B8A" },
            {"FDE0DD", "FA9FB5", "C51B8A" },
            {"FEEBE2", "FBB4B9", "F768A1", "AE017E" },
            {"FEEBE2", "FBB4B9", "F768A1", "C51B8A", "7A0177" },
            {"FEEBE2", "FCC5C0", "FA9FB5", "F768A1", "C51B8A", "7A0177" },
            {"FEEBE2", "FCC5C0", "FA9FB5", "F768A1", "DD3497", "AE017E", "7A0177" },
            {"FFF7F3", "FDE0DD", "FCC5C0", "FA9FB5", "F768A1", "DD3497", "AE017E", "7A0177" },
            {"FFF7F3", "FDE0DD", "FCC5C0", "FA9FB5", "F768A1", "DD3497", "AE017E", "7A0177", "49006A" }
    }),
    Reds(3, "Red shades", true, new String[][]{
            {"FEE0D2" },
            {"FEE0D2", "DE2D26" },
            {"FEE0D2", "FC9272", "DE2D26" },
            {"FEE5D9", "FCAE91", "FB6A4A", "CB181D" },
            {"FEE5D9", "FCAE91", "FB6A4A", "DE2D26", "A50F15" },
            {"FEE5D9", "FCBBA1", "FC9272", "FB6A4A", "DE2D26", "A50F15" },
            {"FEE5D9", "FCBBA1", "FC9272", "FB6A4A", "EF3B2C", "CB181D", "99000D" },
            {"FFF5F0", "FEE0D2", "FCBBA1", "FC9272", "FB6A4A", "EF3B2C", "CB181D", "99000D" },
            {"FFF5F0", "FEE0D2", "FCBBA1", "FC9272", "FB6A4A", "EF3B2C", "CB181D", "A50F15", "67000D" }
    }),
    YlGn(3, "Yellow-Green shades", true, new String[][]{
            {"F7FCB9" },
            {"F7FCB9", "31A354" },
            {"F7FCB9", "ADDD8E", "31A354" },
            {"FFFFCC", "C2E699", "78C679", "238443" },
            {"FFFFCC", "C2E699", "78C679", "31A354", "006837" },
            {"FFFFCC", "D9F0A3", "ADDD8E", "78C679", "31A354", "006837" },
            {"FFFFCC", "D9F0A3", "ADDD8E", "78C679", "41AB5D", "238443", "005A32" },
            {"FFFFE5", "F7FCB9", "D9F0A3", "ADDD8E", "78C679", "41AB5D", "238443", "005A32" },
            {"FFFFE5", "F7FCB9", "D9F0A3", "ADDD8E", "78C679", "41AB5D", "238443", "006837", "004529" }
    }),
    YlGnBu(3, "Yellow-Green-Blue shades", true, new String[][]{
            {"EDF8B1" },
            {"EDF8B1", "2C7FB8" },
            {"EDF8B1", "7FCDBB", "2C7FB8" },
            {"FFFFCC", "A1DAB4", "41B6C4", "225EA8" },
            {"FFFFCC", "A1DAB4", "41B6C4", "2C7FB8", "253494" },
            {"FFFFCC", "C7E9B4", "7FCDBB", "41B6C4", "2C7FB8", "253494" },
            {"FFFFCC", "C7E9B4", "7FCDBB", "41B6C4", "1D91C0", "225EA8", "0C2C84" },
            {"FFFFD9", "EDF8B1", "C7E9B4", "7FCDBB", "41B6C4", "1D91C0", "225EA8", "0C2C84" },
            {"FFFFD9", "EDF8B1", "C7E9B4", "7FCDBB", "41B6C4", "1D91C0", "225EA8", "253494", "081D58" }
    }),
    YlOrBr(3, "Yellow-Orange-Brown shades", true, new String[][]{
            {"FFF7BC" },
            {"FFF7BC", "D95F0E" },
            {"FFF7BC", "FEC44F", "D95F0E" },
            {"FFFFD4", "FED98E", "FE9929", "CC4C02" },
            {"FFFFD4", "FED98E", "FE9929", "D95F0E", "993404" },
            {"FFFFD4", "FEE391", "FEC44F", "FE9929", "D95F0E", "993404" },
            {"FFFFD4", "FEE391", "FEC44F", "FE9929", "EC7014", "CC4C02", "8C2D04" },
            {"FFFFE5", "FFF7BC", "FEE391", "FEC44F", "FE9929", "EC7014", "CC4C02", "8C2D04" },
            {"FFFFE5", "FFF7BC", "FEE391", "FEC44F", "FE9929", "EC7014", "CC4C02", "993404", "662506" }
    }),
    YlOrRd(3, "Yellow-Orange-Red shades", true, new String[][]{
            {"FFEDA0" },
            {"FFEDA0", "F03B20" },
            {"FFEDA0", "FEB24C", "F03B20" },
            {"FFFFB2", "FECC5C", "FD8D3C", "E31A1C" },
            {"FFFFB2", "FECC5C", "FD8D3C", "F03B20", "BD0026" },
            {"FFFFB2", "FED976", "FEB24C", "FD8D3C", "F03B20", "BD0026" },
            {"FFFFB2", "FED976", "FEB24C", "FD8D3C", "FC4E2A", "E31A1C", "B10026" },
            {"FFFFCC", "FFEDA0", "FED976", "FEB24C", "FD8D3C", "FC4E2A", "E31A1C", "B10026" },
            {"FFFFCC", "FFEDA0", "FED976", "FEB24C", "FD8D3C", "FC4E2A", "E31A1C", "BD0026", "800026" }
    }),
    hsvRdBl(1, "HSV Red-Blue", true, new String[][]{
            {"FF0000" },
            {"FF0000", "0000FF" },
            {"FF0000", "FFFFFF", "0000FF" },
            {"FF0000", "FFAAAA", "AAAAFF", "0000FF" },
            {"FF0000", "FF8080", "FFFFFF", "8080FF", "0000FF" },
            {"FF0000", "FF6666", "FFCCCC", "CCCCFF", "6666FF", "0000FF" },
            {"FF0000", "FF5555", "FFAAAA", "FFFFFF", "AAAAFF", "5555FF", "0000FF" },
            {"FF0000", "FF4949", "FF9292", "FFDBDB", "DBDBFF", "9292FF", "4949FF", "0000FF" },
            {"FF0000", "FF4040", "FF8080", "FFBFBF", "FFFFFF", "BFBFFF", "8080FF", "4040FF", "0000FF" },
            {"FF0000", "FF3939", "FF7171", "FFAAAA", "FFE3E3", "E3E3FF", "AAAAFF", "7171FF", "3939FF", "0000FF" },
            {"FF0000", "FF3333", "FF6666", "FF9999", "FFCCCC", "FFFFFF", "CCCCFF", "9999FF", "6666FF", "3333FF", "0000FF" }
    }),
    hsvCyMg(1, "HSV Cy-Mg", true, new String[][]{
            {"00FFFF" },
            {"00FFFF", "FF00FF" },
            {"00FFFF", "FFFFFF", "FF00FF" },
            {"00FFFF", "AAFFFF", "FFAAFF", "FF00FF" },
            {"00FFFF", "80FFFF", "FFFFFF", "FF80FF", "FF00FF" },
            {"00FFFF", "66FFFF", "CCFFFF", "FFCCFF", "FF66FF", "FF00FF" },
            {"00FFFF", "55FFFF", "AAFFFF", "FFFFFF", "FFAAFF", "FF55FF", "FF00FF" },
            {"00FFFF", "49FFFF", "92FFFF", "DBFFFF", "FFDBFF", "FF92FF", "FF49FF", "FF00FF" },
            {"00FFFF", "40FFFF", "80FFFF", "BFFFFF", "FFFFFF", "FFBFFF", "FF80FF", "FF40FF", "FF00FF" },
            {"00FFFF", "39FFFF", "71FFFF", "AAFFFF", "E3FFFF", "FFE3FF", "FFAAFF", "FF71FF", "FF39FF", "FF00FF" },
            {"00FFFF", "33FFFF", "66FFFF", "99FFFF", "CCFFFF", "FFFFFF", "FFCCFF", "FF99FF", "FF66FF", "FF33FF", "FF00FF" }
    });

    private final int paletteType;
    private final String paletteDescription;
    private final String[][] hexColors;
    private boolean colorBlindSave;

    ColorBrewer(int paletteType, String paletteDescription, boolean colorBlindSave, String[][] hexColors) {
        this.paletteType = paletteType;
        this.paletteDescription = paletteDescription;
        this.colorBlindSave = colorBlindSave;
        this.hexColors = hexColors;
    }

    public String getPaletteDescription() {
        return paletteDescription;
    }

    public int getMaximumColorCount() {
        return hexColors.length;
    }

    public boolean isColorBlindSave() {
        return colorBlindSave;
    }

    public int[] getColorPalette(int colorCount) {
        if (colorCount < getMaximumColorCount()) {
            return toColor(colorCount);
        } else {
            // if the color count exceeds the number of a
            // available in a palette, interpolate between
            // colors to create an extended color palette
            return interpolatedColors(colorCount);
        }
    }

    @NotNull
    public static ColorBrewer[] getSequentialColorPalettes(boolean colorBlindSave) {
        return getPalettes(3, colorBlindSave);
    }

    @NotNull
    public static ColorBrewer[] getDivergingColorPalettes(boolean colorBlindSave) {
        return getPalettes(1, colorBlindSave);
    }

    @NotNull
    public static ColorBrewer[] getQualitativeColorPalettes(boolean colorBlindSave) {
        return getPalettes(2, colorBlindSave);
    }

    @NotNull
    private static ColorBrewer[] getPalettes(int paletteType, boolean colorBlindSave) {
        List<ColorBrewer> palettes = new ArrayList<>();

        if (colorBlindSave) {
            for (ColorBrewer palette : values()) {
                if (palette.paletteType == paletteType && palette.colorBlindSave) {
                    palettes.add(palette);
                }
            }
        } else {
            for (ColorBrewer palette : values()) {
                if (palette.paletteType == paletteType) {
                    palettes.add(palette);
                }
            }
        }

        return palettes.toArray(new ColorBrewer[palettes.size()]);
    }

    private int[] interpolatedColors(int colorCount) {
        int[] colors = new int[colorCount];
        int maxIndex = getMaximumColorCount() - 1;
        float scale = maxIndex / (float) (colorCount - 1);

        for (int i = 0; i < colorCount; i++) {
            float value = scale * i;
            int index = (int) Math.floor(value);
            int c1 = parseColor(hexColors[maxIndex][index]);
            float remainder = 0.0f;
            int c2;
            if (index + 1 < hexColors.length) {
                c2 = parseColor(hexColors[maxIndex][index + 1]);
                remainder = value - index;
            } else {
                c2 = parseColor(hexColors[maxIndex][index]);
            }
            int red = Math.round((1 - remainder) * Color.red(c1) + (remainder) * Color.red(c2));
            int green = Math.round((1 - remainder) * Color.green(c1) + (remainder) * Color.green(c2));
            int blue = Math.round((1 - remainder) * Color.blue(c1) + (remainder) * Color.blue(c2));

            colors[i] = Color.rgb(red, green, blue);
        }
        return colors;
    }

    private int[] toColor(int numberOfColors) {
        int[] colors = new int[numberOfColors];
        for (int i = 0; i < numberOfColors; i++) {
            colors[i] = parseColor(hexColors[numberOfColors - 1][i]);
        }
        return colors;
    }

    private int parseColor(String color) {
        return Color.parseColor("#" + color);
    }
}
