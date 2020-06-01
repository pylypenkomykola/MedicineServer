package pl.edu.pwsztar.domain.mapper.converter;

public interface Convert<F,T> {
   T convert(F from);
}
