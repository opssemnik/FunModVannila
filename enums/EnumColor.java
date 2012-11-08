package FunMod.enums;

/**
 * Enum feito para o mod funmod poder usar textos coloridos quando checkar a sua vercao
 * @author Antonio
 */
public enum EnumColor
{
	BLACK("\u00a70"),
	DARK_BLUE("\u00a71"),
	DARK_GREEN("\u00a72"),
	DARK_AQUA("\u00a73"),
	DARK_RED("\u00a74"),
	PURPLE("\u00a75"),
	ORANGE("\u00a76"),
	GREY("\u00a77"),
	DARK_GREY("\u00a78"),
	INDIGO("\u00a79"),
	BRIGHT_GREEN("\u00a7a"),
	AQUA("\u00a7b"),
	RED("\u00a7c"),
	PINK("\u00a7d"),
	YELLOW("\u00a7e"),
	WHITE("\u00a7f");
	
	/** A Cor para ser Renderizada no Minecraft */
	public final String code;
	
	private EnumColor(String s)
	{
		code = s;
	}
	
	public String toString()
	{
		return code;
	}
}