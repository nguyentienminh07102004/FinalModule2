package Repository.IMPL;

import Repository.IFileAction;
import Repository.mapper.IRowMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAction<T> implements IFileAction<T> {
    @Override
    public List<T> readFromFile(String source, IRowMapper<T> rowMapper) {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            file = new File(source);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            List<T> result = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                result.add(rowMapper.Mapper(line));
                line = bufferedReader.readLine();
            }
            return result;
        } catch(IOException ex) {
            return null;
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if(fileReader != null) fileReader.close();
            } catch(IOException ignored) {

            }
        }
    }

    @Override
    public void writeToFile(String source, IRowMapper<T> rowMapper, List<T> data) {
        File file = new File(source);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(T t : data) {
                bufferedWriter.write(rowMapper.writeToFile(t));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) bufferedWriter.close();
                if(fileWriter != null) fileWriter.close();
            } catch (IOException ignored) {

            }
        }
    }
}
