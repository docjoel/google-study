import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class studyModel
{
  public String[] sStatements = shuffler.getShuffledStatements();
  public String[] lowLocation = shuffler.getShuffledLowFile();
  public int statementNumber;
  public String[] topLocation = shuffler.getShuffledTopFile();
  public String instruction;
  public String[] key = shuffler.getShuffledKeys();
  public String[] fileName = shuffler.getFileKeys();
  public File mFile;
  
  studyModel()
  {
    this.statementNumber = 0;
  }
  
  public String[] getStatements()
  {
    return this.sStatements;
  }
  
  public String[] getLowStatements()
  {
    return this.lowLocation;
  }
  
  public String[] getTopLocation()
  {
    return this.topLocation;
  }
  
  public String getStatement(int statementNumber)
  {
    return this.sStatements[statementNumber];
  }
  
  public String getStatement()
  {
    return this.sStatements[this.statementNumber];
  }
  
  public void advStatement()
  {
    this.statementNumber += 1;
  }
  
  public String getTopLocation(int topLocationNumber)
  {
    return this.topLocation[topLocationNumber];
  }
  
  public String getLowLocation(int lowLocationNumber)
  {
    return this.lowLocation[lowLocationNumber];
  }
  
  public void makeFile()
  {
    try
    {
      FileWriter localFileWriter = new FileWriter(getFileKey(this.statementNumber) + ".txt");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public String getLocation(int topNumber, int lowNumber)
  {
    makeFile();
    return "please put " + getFileKey(this.statementNumber) + ".txt located on the desktop in " + getTopLocation(topNumber) + " and then in " + getLowLocation(lowNumber) + ", then close the window";
  }
  
  public String LocationShortHand(int topNumber, int lowNumber)
  {
    return getTopLocation(topNumber) + " / " + getLowLocation(lowNumber);
  }
  
  public Boolean checkLocation(int topNumber, int lowNumber)
  {
    File f = new File(getTopLocation(topNumber) + "/" + getLowLocation(lowNumber) + "/" + getFileKey(this.statementNumber) + ".txt");
    if ((f.exists()) && (!f.isDirectory())) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public String locationTest(int topNumber, int lowNumber)
  {
    return getTopLocation(topNumber) + "/" + getLowLocation(lowNumber) + "/" + getFileKey(this.statementNumber) + ".txt";
  }
  
  public String getKey(int i)
  {
    return this.key[i];
  }
  
  public String[] getKeys()
  {
    return this.key;
  }
  
  public String getFileKey(int i)
  {
    return this.fileName[i];
  }
}
