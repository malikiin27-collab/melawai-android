package id.melawai.pegawai;
final class AppConfig {
 static final String ORIGIN="https://melawai.datawebs.my.id";
 static final String BASE=ORIGIN;
 static boolean trusted(android.net.Uri u){return "https".equals(u.getScheme()) && "melawai.datawebs.my.id".equals(u.getHost()) && (u.getPort()==-1 || u.getPort()==443) && (u.getPath()!=null && u.getPath().startsWith("/"));}
}
