package csvHandling;

public class Stair
{
	public String lineType = "Power";
	public double value = 30000;
	public double cutLoss = 10;
	public boolean shutdown = false; //It's manual, if shutdown, it will not be re-activated unless edit csv
	public int reActivateTime = 100000;
	public boolean buying = true;
	public boolean selling = true;
}
