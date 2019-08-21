
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.net.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String location = scan.nextLine();
		String target = scan.nextLine();
		
		String html = getHtml(location);
		Vector<String> domain = getDomain(html);
		
		Collections.sort(domain);
		for(String string : domain) {
			if (string.contains(target)){
				System.out.println(string);
			}
		}
	}
	
	public static String getHtml(String location) throws Exception {
		URL.setURLStreamHandlerFactory(TUProxy::new);
		URL url = new URL(location);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		String input;
		StringBuffer html = new StringBuffer();
		while((input=in.readLine())!=null) {
			html.append(input);
		}
		String text = decodeURLEscape(html.toString()).toLowerCase();
		return text;
	}
	
	public static Vector<String> getDomain(String text) {
		String REGEX = "([0-9a-z%@]+\\.)+com";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(text);
		Vector<String> domain = new Vector<String>();
		while(matcher.find()) {
			String finalDomain = deleteFirstSymbol(matcher.group());
			if (domain.indexOf(finalDomain)==-1) domain.add(finalDomain);
		}
		return domain;
	}
	
	public static String deleteFirstSymbol(String text) {
		String REGEX = "^[^0-9a-z]+";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(text);
		return matcher.replaceAll("");
	}
	
	public static String decodeURLEscape(final String text)
	{
		Pattern escapePattern = Pattern.compile("%([0-9A-Fa-f]{2})");
		final Matcher matcher = escapePattern.matcher(text);
		final StringBuffer sb = new StringBuffer();
		while (matcher.find()) { // eg. matched "%24" from "baidu.com%2F%3Fsearch=%2412345" , last match is "%3F"
			final char replaceChar = (char) Integer.parseInt(matcher.group(1), 16); // eg. "24" -> 0x24 -> '$'
			final String replacement = Matcher.quoteReplacement(Character.toString(replaceChar)); // eg. '$' -> "\\$"
			matcher.appendReplacement(sb, replacement); // eg. append "search=$"
		}
		matcher.appendTail(sb); // eg. append "12345"
		return sb.toString(); // eg. return "baidu.com/?search=$12345"
	}

}

