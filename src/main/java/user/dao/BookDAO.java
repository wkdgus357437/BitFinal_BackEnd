package user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import user.bean.BookDTO;

import java.util.List;

public interface BookDAO extends JpaRepository<BookDTO, String> {
    @Query("select bookDTO from BookDTO bookDTO where bookDTO.movie_date = :keyword")
    public List<BookDTO> movieList(@Param("keyword")String movie_date);
    @Query("select bookDTO from BookDTO bookDTO where bookDTO.movie_date = :keyword and bookDTO.movie_title = :keyword2")
    public List<BookDTO> cityList(@Param("keyword2")String movie_title, @Param("keyword")String movie_date);
    @Query("select bookDTO from BookDTO bookDTO where bookDTO.movie_date = :keyword and bookDTO.movie_title = :keyword2 and bookDTO.movie_city = :keyword3")
    public List<BookDTO> cinemaList(@Param("keyword2")String movie_title, @Param("keyword")String movie_date, @Param("keyword3")String movie_city);
    @Query("select bookDTO from BookDTO bookDTO where bookDTO.movie_date = :keyword and bookDTO.movie_title = :keyword2 and bookDTO.movie_city = :keyword3 and bookDTO.movie_cinema = :keyword4 order by bookDTO.movie_time asc ")
    public List<BookDTO> timeList(@Param("keyword2")String movie_title, @Param("keyword")String movie_date, @Param("keyword3")String movie_city, @Param("keyword4")String movie_cinema);

}
