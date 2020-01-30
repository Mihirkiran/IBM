class SplittingAString{
	
	static String[] mySplit(String str, String delimiter){
		int i, j = 0, k = 0, a = 0;

		int len = delimiter.length();
		for(i = 0; i <= str.length() - len; i++){
			if(delimiter.equals(str.substring(i, i+len))){
				a++;
				i = i + len;
			}
		}
		a++;
		String[] strArr = new String[a];
		for(i = 0; i <= str.length() - len; i++){
			if(delimiter.equals(str.substring(i, i+len))){
				strArr[j++] = str.substring(k, i);
				k = i + len;
				i = i + len;
			}
		}
		if(!delimiter.equals(str.substring(k)))
			strArr[j] = str.substring(k);
		
		return strArr;
	}
	public static void main(String[] args) {
		String[] sp = mySplit("Hello howaaaaa whatsaaaa going on aaa", ",");
		for(int i = 0; i < sp.length; i++){
			System.out.println(sp[i]);
		}
	}
}