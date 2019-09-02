/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.dbutil.DBConnection;
import TechQuizApp.pojo.QuestionPojo;
import TechQuizApp.pojo.QuestionStore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class QuestionDAO {
    public static void addQuestions(QuestionStore qstore)throws SQLException
    {
        String qry="Insert into Questions values(?,?,?,?,?,?,?,?,?)";
        ArrayList <QuestionPojo> questionList =qstore.getAllQuestions();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        for(QuestionPojo obj:questionList)
        {
            ps.setString(1,obj.getExamId());
            ps.setString(2,obj.getQuestion());
            ps.setString(3,obj.getAnswer1());
            ps.setString(4,obj.getAnswer2());
            ps.setString(5,obj.getAnswer3());
            ps.setString(6,obj.getAnswer4());
            ps.setString(7,obj.getCorrectAnswer());
            ps.setString(8,obj.getLanguage());
            ps.setInt(9,obj.getQno());
            ps.executeUpdate();
        }

    }
    public static ArrayList<QuestionPojo> getQuestionByExamId(String examId)throws SQLException
    {
        String qry="select * from questions where examId=? order by qno";
        ArrayList <QuestionPojo> questionList =new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,examId);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            String question=rs.getString(2);
            String option1=rs.getString(3);
            String option2=rs.getString(4);
            String option3=rs.getString(5);
            String option4=rs.getString(6);
            String correctAnswer=rs.getString(7);
            String language=rs.getString(8);
            int qno=rs.getInt(9);
            QuestionPojo obj=new QuestionPojo(examId,qno,language,option1,option2,option3,option4,correctAnswer,question);
            questionList.add(obj);
                
        }
        System.out.println("Total Qustions are:"+questionList.size());    
        return questionList;
        }

      public static void updateQuestions(QuestionStore qstore)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where language=? and examid=? and qno=?");
         ArrayList <QuestionPojo> questionList=qstore.getAllQuestions();
        for(QuestionPojo obj:questionList){
           ps.setString(1, obj.getQuestion());
           ps.setString(2, obj.getAnswer1());
           ps.setString(3, obj.getAnswer2());
           ps.setString(4, obj.getAnswer3());
           ps.setString(5, obj.getAnswer4());
           ps.setString(6, obj.getCorrectAnswer());
           ps.setString(7, obj.getLanguage());
           ps.setString(8, obj.getExamId());
           ps.setInt(9, obj.getQno());
           ps.executeUpdate();
           }
    }
      
        public static ArrayList<QuestionPojo> getQuestionsForEdit(String language,String examId)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from questions where language=? and examid=?");
        ps.setString(1, language);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        ArrayList<QuestionPojo> questions=new ArrayList<>();
        while(rs.next())
        {
            QuestionPojo question=new QuestionPojo();
            question.setExamId(rs.getString(1));
            question.setQuestion(rs.getString(2));
            question.setAnswer1(rs.getString(3));
            question.setAnswer2(rs.getString(4));
            question.setAnswer3(rs.getString(5));
            question.setAnswer4(rs.getString(6));
            question.setCorrectAnswer(rs.getString(7));
            question.setLanguage(rs.getString(8));
            question.setQno(rs.getInt(9));

            questions.add(question);
        }
        return questions;
    }
}
