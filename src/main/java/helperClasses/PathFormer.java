package helperClasses;

public class PathFormer {

    private static String baseUrl;

    public PathFormer(String baseUrl) {
        this.baseUrl =baseUrl;
    }


    public String formSinglePostcodePath(String postCode) {  return formPath("postcodes", postCode);  }

    public String formNearestPostcodePath() {  return formPath("postcodes");  }

    public String formRandomPostcodePath() {  return formPath("random","postcodes");  }


    /**
     * Appends pathParts to the baseUrl and Version to form the entire url for a call
     *
     * @param pathParts will be automatically separated with /
     * @return
     */
    private String formPath(String... pathParts) {
        StringBuilder sb = new StringBuilder();
        sb.append(baseUrl);
        sb.append("/" + String.join("/", pathParts));

        return sb.toString();
    }



}
