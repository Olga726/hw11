package complex.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradeService<T extends Number> {
    private List<StudentGrade<T>> list = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grade) {
        if (grade.getGrade()==null || grade.getGrade().doubleValue() < 0) {
            throw new InvalidGradeException("Оценка не может быть отрицательной и null");
        }
        list.add(grade);
    }

    public double calculateAverage(String subject) {

        List<StudentGrade<T>> filtered = list.stream()
                .filter(n -> n.getSubject().equalsIgnoreCase(subject))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) throw new InvalidGradeException("Нет оценок по предмету " + subject);

        return filtered.stream()
                .mapToDouble(n -> n.getGrade().doubleValue())
                .average()
                .orElse(0.00);


    }

    public List<StudentGrade<T>> getAll() {
        return new ArrayList<>(list);
    }
}
