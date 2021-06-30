defmodule Grades.Calculator do
  def percentage_grade(marks) do
    :rand.uniform(100)
  end

  def letter_grade(marks) do
    Enum.random(["A+", "A", "A-","B+","B","C+","C","D+","D","EIN","F"])
    end

  def numeric_grade(marks) do
    :rand.uniform(10)
  end
end
