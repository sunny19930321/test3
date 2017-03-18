package daidai.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ID3 {

    /**
     * �ļ�����ȡѵ��Ԫ��
     * 
     * @return ѵ��Ԫ�鼯��
     * @throws IOException
     */
    public static ArrayList<ArrayList<String>> readFData(String fileUrl)
            throws IOException {
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream("F:\\weather.test.txt")));
        String temp = null;
        String[] tempArray = null;
        while ((temp = in.readLine()) != null) {
            tempArray = temp.split("\\t");
            ArrayList<String> s = new ArrayList<String>();
            for (int i = 0; i < tempArray.length; i++) {
                // ///////////////
                s.add(tempArray[i]);
            }
            datas.add(s);
        }
        in.close();
        return datas;
    }

    /**
     * �ļ�����ȡ��ѡ����
     * 
     * @return ��ѡ���Լ���
     * @throws IOException
     */
    public static ArrayList<String> readFCandAttr(String fileUrl)
            throws IOException {
        ArrayList<String> candAttr = new ArrayList<String>();
        String temp = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream("F:\\weather.feature.txt")));
        while ((temp = in.readLine()) != null) {
            candAttr.add(temp);
        }
        in.close();
        return candAttr;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<ArrayList<String>> Datas = readFData("F:\\weather.test.txt"); //���������ļ� �������� ����table������
        ArrayList<String> features = readFCandAttr("F:\\weather.feature.txt"); //���������ļ� �������� ����table������

        DecisionTree.buildTree(Datas, features);
    }
}