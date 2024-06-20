String nfeUrl = "https://example.com/download/nfe123.xml";

DownloadNfe downloadNfeTask = new DownloadNfe();
downloadNfeTask.setDownloadListener(new DownloadNfe.DownloadListener() {
    @Override
    public void onDownloadComplete(File file) {
        // Handle downloaded file here (e.g., display, parse, etc.)
        Log.d(TAG, "Downloaded file path: " + file.getAbsolutePath());
    }

    @Override
    public void onError(String errorMessage) {
        // Handle download error
        Log.e(TAG, "Download error: " + errorMessage);
    }
});
downloadNfeTask.execute(nfeUrl);

