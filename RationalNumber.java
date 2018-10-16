public class RationalNumber extends RealNumber{
  private int num, den;

  public RationalNumber(int num, int den){
    this.int = num;
    this.den = den;
    super((num + 0.0) / den);
  }

  public String toString(){
    return num + "/ " + den;
  }

  public int getNum(){
    return num;
  }

  public int getDen(){
    return den;
  }

  public void simplify(){
  }

  public double toDouble(){
    return 0.0;
  }



}
