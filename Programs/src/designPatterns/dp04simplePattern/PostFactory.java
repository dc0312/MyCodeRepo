package designPatterns.dp04simplePattern;

/**
 * This class acts as a simple factory for creation of 
 * different posts on web site.
 *
 */
public class PostFactory {

    public static Post getInstance(String key){
        switch (key){
            case "News" : return new NewsPost();
            case "Product" :  return new ProductPost();
            case "Blog" : return  new BlogPost();
            default: throw new IllegalArgumentException("Post type unknown");
        }
    }

}
