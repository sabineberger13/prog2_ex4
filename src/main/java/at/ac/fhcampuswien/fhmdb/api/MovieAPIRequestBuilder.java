package at.ac.fhcampuswien.fhmdb.api;

public class MovieAPIRequestBuilder {
    private String baseUrl;
    private String query;
    private String genre;
    private String releaseYear;
    private String ratingFrom;

    public static final String DELIMITER = "&";

    public MovieAPIRequestBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public MovieAPIRequestBuilder query(String query) {
        this.query = query;
        return this;
    }

    public MovieAPIRequestBuilder genre(String genre) {
        this.genre = genre;
        return this;
    }

    public MovieAPIRequestBuilder releaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public MovieAPIRequestBuilder ratingFrom(String ratingFrom) {
        this.ratingFrom = ratingFrom;
        return this;
    }

    public String build() {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);

        if ((query != null && !query.isEmpty()) ||
                genre != null || releaseYear != null || ratingFrom != null) {
            urlBuilder.append("?");
        } else {
            if (query != null) {
                urlBuilder.append("query=").append(query).append(DELIMITER);
            }

            if (genre != null) {
                urlBuilder.append("genre=").append(genre).append(DELIMITER);
            }

            if (releaseYear != null) {
                urlBuilder.append("releaseYear=").append(releaseYear).append(DELIMITER);
            }

            if (ratingFrom != null) {
                urlBuilder.append("ratingFrom=").append(ratingFrom).append(DELIMITER);
            }
        }

        return urlBuilder.toString();
    }
}