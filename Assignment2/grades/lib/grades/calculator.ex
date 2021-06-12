defmodule Grades.Calculator do
  def percentage_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)


    avg_labs = avg(labs)

    mark = 0.2 * avg_labs + 0.3 * avg_homework + 0.2 * midterm + 0.3 * final
    round(mark * 100)
  end

  def avg(classwork) do
     if Enum.count(classwork) == 0 do
       0
     else
       Enum.sum(classwork) / Enum.count(classwork)
     end
  end

  def failed_to_participate(homework, labs) do
    num_labs =
      labs
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()
    avg_homework = avg(homework)
    if avg_homework < 0.4 || num_labs < 3 do
      "EIN"
    end
  end

  def calculate_grade(homework,labs,final,midterm) do
   0.2 * labs + 0.3 * homework + 0.2 * midterm + 0.3 * final
  end

  def mark_to_letter(mark) do
    cond do
      mark > 0.895 -> "A+"
      mark > 0.845 -> "A"
      mark > 0.795 -> "A-"
      mark > 0.745 -> "B+"
      mark > 0.695 -> "B"
      mark > 0.645 -> "C+"
      mark > 0.595 -> "C"
      mark > 0.545 -> "D+"
      mark > 0.495 -> "D"
      mark > 0.395 -> "E"
      :else -> "F"
      end
  end


  def letter_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)
    avg_labs = avg(labs)

    avg_exams = (midterm + final) / 2

    participate = failed_to_participate(homework,labs)
    if participate == "EIN" || avg_exams < 0.4 do
      "EIN"
    else
      mark = calculate_grade(avg_homework,avg_labs,final,midterm)

      mark_to_letter(mark)
    end
  end


  def mark_to_number(mark) do
    cond do
      mark > 0.895 -> 10
      mark > 0.845 -> 9
      mark > 0.795 -> 8
      mark > 0.745 -> 7
      mark > 0.695 -> 6
      mark > 0.645 -> 5
      mark > 0.595 -> 4
      mark > 0.545 -> 3
      mark > 0.495 -> 2
      mark > 0.395 -> 1
      :else -> 0
      end
  end

  def numeric_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)

    avg_labs = avg(labs)

    avg_exams = (midterm + final) / 2

    participate = failed_to_participate(homework,labs)
    if participate == "EIN" || avg_exams < 0.4 do
      0
    else
      mark = calculate_grade(avg_homework,avg_labs,final,midterm)

      mark_to_number(mark)
    end
  end
end
