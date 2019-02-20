package info.burahan.languages;

public class LanguageNotFoundException extends RuntimeException
{
    public LanguageNotFoundException(Long id)
    {
        super("Could not find language");
    }
}
