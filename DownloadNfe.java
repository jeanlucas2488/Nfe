import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadNfe extends AsyncTask<String, Void, File> {

    private static final String TAG = "DownloadNfe";

    private DownloadListener listener;

    public interface DownloadListener {
        void onDownloadComplete(File file);
        void onError(String errorMessage);
    }

    public void setDownloadListener(DownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected File doInBackground(String... urls) {
        if (urls.length == 0) {
            return null;
        }

        String urlStr = urls[0];
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
			.url(urlStr)
			.build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Save the downloaded file
                File outputFile = File.createTempFile("nfe_", ".xml");
                FileOutputStream outputStream = new FileOutputStream(outputFile);
                outputStream.write(response.body().bytes());
                outputStream.close();
                return outputFile;
            } else {
                Log.e(TAG, "Download failed: " + response.code() + " " + response.message());
                return null;
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException during download: " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(File file) {
        if (file != null) {
            if (listener != null) {
                listener.onDownloadComplete(file);
            }
        } else {
            if (listener != null) {
                listener.onError("Download failed");
            }
        }
    }
}

