package com.dnkrn.evolver.workouts;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

/**
 * Created by dinakaran on 8/22/17.
 */
public class GetMovieInfo {


    static String[] getMovieTitles(final String substr) {

        try {

            Gson gson = new Gson();

            String urlToRead = "https://someapi.com/search/?Title=" + substr;

            String response = getURlResponse(urlToRead);

            MovieMetaData metaData = gson.fromJson(response, MovieMetaData.class);

            int totalPages = Integer.parseInt(metaData.getTotal_pages());

            List<String> titles = extractTitles(metaData.getData(), substr);

            for (int index = 2; index <= totalPages; index++) {

                urlToRead = "https://someapi.com/search/?Title=" + substr + "&page=" + index;

                response = getURlResponse(urlToRead);

                metaData = gson.fromJson(response, MovieMetaData.class);

                titles.addAll(extractTitles(metaData.getData(), substr));
            }

            Collections.sort(titles);

            return titles.toArray(new String[titles.size()]);


        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }

    }

    private static String getURlResponse(String urlToRead) {

        String response = "";

        try {

            URL url = new URL(urlToRead);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            try (
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));) {

                String line;

                StringBuilder result = new StringBuilder();

                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

                response = result.toString();
            } catch (IOException ie) {

            }

        } catch (MalformedURLException | ProtocolException pe) {

        } catch (IOException e) {

        }


        return response;
    }

    private static List<String> extractTitles(List<MovieInfo> data, String substr) {


        String regex = "(.*)" + substr + "(.*)";

        final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> titles= new ArrayList<>();
        for(MovieInfo movie:data)
        {
            Matcher matcher = pattern.matcher(movie.getTitle());
            if (matcher.find()) {
                titles.add(movie.getTitle());
            }
        }



        return titles;
    }


    class MovieMetaData {

        private String page;

        private String per_page;

        private String total;

        private String total_pages;

        private List<MovieInfo> data;


        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPer_page() {
            return per_page;
        }

        public void setPer_page(String per_page) {
            this.per_page = per_page;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(String total_pages) {
            this.total_pages = total_pages;
        }

        public List<MovieInfo> getData() {
            return data;
        }

        public void setData(List<MovieInfo> data) {
            this.data = data;
        }


    }

    class MovieInfo {

        private String Poster;
        private String Title;
        private String Type;
        private String Year;
        private String imdbID;


        public String getPoster() {
            return Poster;
        }

        public void setPoster(String poster) {
            Poster = poster;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String year) {
            Year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }
    }

    public static void main(String[] args) {

        for (String title : getMovieTitles("great")) {
            System.out.println(title);
        }

    }
}


