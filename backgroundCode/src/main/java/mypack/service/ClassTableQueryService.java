package mypack.service;

public interface ClassTableQueryService {
    String getProfessorClassTable(long id,String learnYear,int learnTerm);
    String getStudentClassTable(long id,String learnYear,int learnTerm);

}
