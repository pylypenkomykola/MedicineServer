package pl.pwsztar.edu.domain.mapper.converter;

public interface Convert<F,T> {
   T convert(F from);
}
