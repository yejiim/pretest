# pretest

## jar 파일 다운로드 링크 or 디렉토리 경로 
- [다운로드](https://github.com/yejiim/pretest/raw/main/jar/kakaobank-0.0.1-SNAPSHOT.jar)   
- [pretest/jar 디렉토리](https://github.com/yejiim/pretest/blob/main/jar/kakaobank-0.0.1-SNAPSHOT.jar)

## API 명세 
- 검색: /search

### 블로그 검색 `GET` /search/blog

#### Request Parameter 
| parameter name  | type  | default value   | desc  | 
|---|---|---|---|
| sort  | String  | accuracy (Sort.ACCURACY)  |  정렬 타입 (accuracy/recency) | 
| query  | String  | -    |  질의어  |  
|page   | Int  | 1  | 조회하는 페이지 (1부터 시작)  |
|size   | Int  | 10 |  한 페이지에 보여지는 documents의 개수 |

### Response
```json
{
    "meta": {
        "total_count": 854692,
        "pageable_count": 799,
        "end": false
    },
    "documents": [
        {
            "title": "<b>아이유</b>",
            "contents": "더보기 <b>아이유</b>콘서트 후기 <b>아이유</b> 콘서트가 성황리에 잘 마무리되었는데 그 후일담들이 여기저기서 올라오고 있다. 이번 <b>아이유</b> 콘서트에서 적자일 정도로 팬들에게 아낌없이 쏟아부었다고 하는데 그전에 없었던 사진들을 다시 모아봤다. 열기구에서 등장하는 <b>아이유</b> 개인 콘서트에서 열기구를 소환해 노래 부르는...",
            "url": "http://sideeveryroom81.tistory.com/8",
            "blogname": "편이객실마다",
            "thumbnail": "https://search4.kakaocdn.net/argon/130x130_85_c/E6Hj99uZGZL",
            "datetime": "2022-09-21T22:14:32.000+09:00"
        },
        ,,,
    ]
}
```

- 질의어를 기준으로 블로그 검색 결과를 조회 
- default 검색 엔진은 카카오 
    - 카카오 검색 장애 시 -> 네이버 (미구현)  



### 인기 검색어 조회 `GET` /search/trending 
#### Request Parameter 
NONE 

### Response 
```json
{
    "list": [
        {
            "query": "아이유콘서트",
            "count": 10
        },
        {
            "query": "카카오뱅크",
            "count": 7
        },
        ...
    ]
}
```

- 상위 인기검색어 10개를 리스트로 조회 
- 조회수도 같이 노출 
