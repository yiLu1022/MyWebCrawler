package com.ylu.douyuFormat;

public class Formating {
	public static String bytes2Hex(byte[] bytes){
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes){
			byte high =  (byte) ((b & 0xf0)>>4);
			if( high <= 0x09 ){
				sb.append(String.valueOf(high));
			}else{
				int ascii = (high - 0x0a) + 65;
				sb.append((char)ascii);
			}
			
			byte low =  (byte) (b & 0x0f);
			if( low <= 0x09 ){
				sb.append(String.valueOf(low));
			}else{
				int ascii = (low - 0x0a) + 65;
				sb.append((char)ascii);
			}
			sb.append(",");
		}
		return sb.toString();
	}
	
	public static int fromLH(byte[] bytes){
/*		n += (bytes[3] & 0xff) << 24;
		n += (bytes[2] & 0xff) << 16;
		n += (bytes[1] & 0xff) << 8;
		n += (bytes[0] & 0xff);*/
		
	    int value;    
	    value = (int) ((bytes[0] & 0xFF)   
	            | ((bytes[1] & 0xFF)<<8)   
	            | ((bytes[2] & 0xFF)<<16)   
	            | ((bytes[3] & 0xFF)<<24));  
	    return value;
	}
	
	 public   static   byte [] toLH( int  n){
       byte [] b =  new   byte [ 4 ];
       b[0 ] = ( byte ) (n &  0xff );
       b[1 ] = ( byte ) (n >>  8  &  0xff );
       b[2 ] = ( byte ) (n >>  16  &  0xff );
       b[3 ] = ( byte ) (n >>  24  &  0xff );
       return  b;
    }

    public   static   byte [] toHH( int  n)
    {
       byte [] b =  new   byte [ 4 ];
       b[3 ] = ( byte ) (n &  0xff );
       b[2 ] = ( byte ) (n >>  8  &  0xff );
       b[1 ] = ( byte ) (n >>  16  &  0xff );
       b[0 ] = ( byte ) (n >>  24  &  0xff );
       return  b;
    }

    public   static   byte [] toLH( short  n)
    {
       byte [] b =  new   byte [ 2 ];
       b[0 ] = ( byte ) (n &  0xff );
       b[1 ] = ( byte ) (n >>  8  &  0xff );
       return  b;
    }

    public   static   byte [] toHH( short  n)
    {
       byte [] b =  new   byte [ 2 ];
       b[1 ] = ( byte ) (n &  0xff );
       b[0 ] = ( byte ) (n >>  8  &  0xff );
       return  b;
    }
}
