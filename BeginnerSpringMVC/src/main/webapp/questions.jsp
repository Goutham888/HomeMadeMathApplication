<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
 Question 1: ${questionList.get(0)}<br>
 Question 2: ${questionList.get(1)}<br>
 Question 3: ${questionList.get(2)}<br>
 Question 4: ${questionList.get(3)}<br>
 Question 5: ${questionList.get(4)}<br>

<form action="checkAnswers">
  <p> Question 1: ${questionList.get(0)}<br></p>  
  <input type="radio" id="CB" name="Q1" value="Chicken butt">
  <label for="CB">Chicken butt</label><br>  
  <input type="radio" id="TB" name="Q1" value="Turkey butt">
  <label for="TB">Turkey butt</label><br>  
  <input type="radio" id="PB" name="Q1" value="Pheasant butt">
  <label for="PB">Pheasant butt</label><br>
  
  <p> Question 2: ${questionList.get(1)}<br></p>  
  <input type="radio" id="TP" name="Q2" value="Turkey poo">
  <label for="TP">Turkey poo</label><br>  
  <input type="radio" id="BP" name="Q2" value="Bird poo">
  <label for="BP">Bird Poo</label><br>  
  <input type="radio" id="PB" name="Q2" value="Pheasant butt">
  <label for="PB">Pheasant butt</label><br>
  
  <p> Question 3: ${questionList.get(2)}<br></p>  
  <input type="radio" id="SS" name="Q3" value="Stork stare">
  <label for="SS">Stork stare</label><br>  
  <input type="radio" id="TB" name="Q3" value="Turkey butt">
  <label for="TB">Turkey butt</label><br>  
  <input type="radio" id="PB" name="Q3" value="Pheasant butt">
  <label for="PB">Pheasant butt</label><br>
  
  
  
  <p> Question 4: ${questionList.get(3)}<br></p>  
  <input type="radio" id="AH" name="Q4" value="Angry hen">
  <label for="AH">Angry hen</label><br>  
  <input type="radio" id="TB" name="Q4" value="Turkey butt">
  <label for="TB">Turkey butt</label><br>  
  <input type="radio" id="PB" name="Q4" value="Pheasant butt">
  <label for="PB">Pheasant butt</label><br>
  
  <p> Question 5: ${questionList.get(4)}<br></p>  
  <input type="radio" id="PP" name="Q5" value="Pigeon pie">
  <label for="PP">Pigeon pie</label><br>  
  <input type="radio" id="TB" name="Q5" value="Turkey butt">
  <label for="TB">Turkey butt</label><br>  
  <input type="radio" id="PB" name="Q5" value="Pheasant butt">
  <label for="PB">Pheasant butt</label><br>

  <input type="submit" value="Submit">
</form>

</body>
</html>
