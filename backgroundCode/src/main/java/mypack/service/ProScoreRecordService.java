package mypack.service;

public interface ProScoreRecordService {

    String scoreQuery(long id,String year,int term,int type);
    boolean singleScore(long cid,String sid,String score);
    String studentTake(long id);
    Boolean batchScoreRegister(String[] jsonArr);

}
