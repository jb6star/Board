package junsung.variousimp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class SearchResponse{
    private int currentPage;
    private int totalPages;
    private boolean isFirst;
    private boolean isLast;
    private List<String> titles;

}
