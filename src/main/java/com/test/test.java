package com.test;
import com.dao.QuestionsDAO;

public class test {

	public static void main(String[] args) {
		
		QuestionsDAO qdao = new QuestionsDAO();
		
		System.out.println(qdao.getQuestion(1));
		
		
		
	}

}
