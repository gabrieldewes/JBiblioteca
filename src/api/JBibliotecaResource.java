/*
 * The MIT License
 *
 * Copyright 2017 Dewes.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dewes
 */
public class JBibliotecaResource {
    
    private static final Logger LOG = Logger.getLogger(JBibliotecaResource.class.getName());

    private static volatile JBibliotecaResource INSTANCE = null;
    
    public static JBibliotecaResource getInstance() {
        if (INSTANCE == null) {
            synchronized(JBibliotecaResource.class) {
                INSTANCE = new JBibliotecaResource();
            }
        }
        return INSTANCE;
    }
    
    private JBibliotecaResource() {}
    
    private static final String API_URL = "http://dewes.pe.hu/";
    private static final String J_SCRIPTS_PATH = "jbiblioteca/scripts/";
    private static final String BACKUP_URL = API_URL + J_SCRIPTS_PATH + "backup.php";
    
    public String uploadFile(File file) {
        
        String charset = "UTF-8";
        String boundary = Long.toHexString(System.currentTimeMillis());
        String CRLF = "\r\n";
        
        try {
            URLConnection connection = new URL(BACKUP_URL).openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            connection.setRequestProperty("X-JBiblioteca-Auth", "morrinhos");

            try (
                OutputStream output = connection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true) )
            {
                writer.append("--")
                        .append(boundary)
                        .append(CRLF);

                writer.append("Content-Disposition: form-data; name=\"backup_file\"; filename=\"")
                        .append(file.getName())
                        .append("\"")
                        .append(CRLF);

                writer.append("Content-Type: ")
                        .append(URLConnection.guessContentTypeFromName(file.getName()))
                        .append(CRLF);

                writer.append("Content-Transfer-Encoding: binary")
                        .append(CRLF);

                writer.append(CRLF).flush();

                Files.copy(file.toPath(), output);

                output.flush();

                writer.append(CRLF).flush();

                writer.append("--")
                        .append(boundary)
                        .append("--")
                        .append(CRLF)
                        .flush();

                int responseCode = ((HttpURLConnection) connection).getResponseCode();

                LOG.log(Level.INFO, "Server returned {0} from URL " + BACKUP_URL, responseCode);

                switch (responseCode) {
                    case 204:
                        return "OK";
                    case 401:
                        return "UNAUTHORIZED";
                    case 403:
                        return "FORBIDDEN";
                    case 404:
                        return "NOT_FOUND";
                    case 500:
                        return "INTERNAL_SERVER_ERROR";
                    // Hostinger retorna uma pagina 404 com statu 200 caso não encontrar um path
                    case 200: 
                        return "NOT_FOUND";
                    default:
                        return "" + responseCode;
                }

                /*
                // Server response body
                
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
                StringBuilder sb = new StringBuilder();
                String outstr;
                while ((outstr = br.readLine()) != null) {
                    sb.append(outstr);
                }
                LOG.log(Level.INFO, "Server response {0} with status code " + responseCode, sb.toString());
                */

            }

        } catch (Exception ex) {
            // ex.printStackTrace();
            if (ex instanceof java.net.UnknownHostException) {
                return "UNKNOWN_HOST";
            }
        }
        return "NO_RETURN";
    }
    
    public File downloadFile() {
        try {
            URL url = new URL("http://127.0.0.1/scripts/file.php");
            
            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            
            FileOutputStream fileOutputStream = new FileOutputStream("teste.db");
            
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            
            return null;
        } catch (Exception ex) {
            
        }
        return null;
    }
    
    public static void main(String[] args) {
        
        JBibliotecaResource.getInstance().downloadFile();
    }
    
}
