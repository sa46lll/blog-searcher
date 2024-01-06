package com.sa46lll.blogsearcher.dto;

public record GetPopularKeywordQuery(
        int page,
        int size
) {

        public GetPopularKeywordQuery {
            if (page < 1) {
                page = 1;
            }
            if (size < 1) {
                size = 10;
            }
        }
}
