-- 테이블 삭제
drop table ClubLayout;
drop table Clubmember_level;
drop table ClubMember;
drop table ClubBoardComment;
drop table ClubBoard;
drop table ClubList;
drop table FreeBoardComment;
drop table FreeBoard;
drop table GuestBookComment;
drop table GuestBook;
drop table MiniHits;
drop table MiniHomeMain;
drop table UserFriends;
drop table FileMng;
drop table UserInfo;

-- 시퀀스 삭제
drop sequence clubmember_level_Seq;
drop sequence clubmember_Seq;
drop sequence clubboardComments_Seq;
drop sequence clubboard_Seq;
drop sequence club_Seq;
drop sequence board_Seq;
drop sequence guestBookComment_Seq;
drop sequence guestBook_Seq;
drop sequence miniHits_Seq;
drop sequence miniH_Seq;
drop SEQUENCE UserFriends_Seq;
drop SEQUENCE file_seq;
drop SEQUENCE userNo_Seq;


-- 테이블 생성
--유저정보 테이블
create table UserInfo(
    userNo	        number          primary key
    , userId	    varchar2(50)    not null unique
    , userPw	    varchar2(20)    not null
    , userName	    Varchar2(30)    not null
    , userPhone	    Varchar2(30)    
    , userBirth	    date            
    , joinDate	    date            default sysdate
    , deleteFlag	Number(1)       default 0
);
create SEQUENCE userNo_Seq;

--파일 관리 테이블
create table FileMng(
    file_seq	    number          primary key
    , originalName	varchar2(200)   not null
    , saveName	    varchar2(200)   not null
    , path	        varchar2(500)   not null
);
create SEQUENCE file_seq;

--친구(일촌) 테이블
create table UserFriends(
    UserFriends_Seq	number          primary key
    , UserOwner 	number    references UserInfo(UserNo) on delete cascade
    , UserFriend	number    references UserInfo(UserNo) on delete cascade
    , FriendNick	Varchar2(30)    
);
create SEQUENCE UserFriends_Seq;

--미니홈피 정보
create table MiniHomeMain( 
    miniH_Seq	    number          primary key
    , userId	    number          not null references UserInfo(UserNo) on delete cascade
    , userPhoto	    number          not null references FileMng(file_seq)
    , userProfile	Varchar2(200)
    , miniHits	    number          default 0
    , privateFlag	Number(1)       default 0
);
create sequence miniH_Seq;

--미니홈피 방문자체크 (daily unique) & 최근방문자 목록확인용
create table MiniHits(
    miniHits_Seq	number          primary key
    , userId	    number          not null references UserInfo(UserNo) on delete cascade
    , visitorId	    number          not null references UserInfo(UserNo) on delete cascade
    , dateLogger	date            default sysdate
);
create sequence miniHits_Seq;

--방명록
create table GuestBook(
    guestBook_Seq	number          primary key
    , userId	    number          not null references UserInfo(UserNo) on delete cascade
    , writerId	    number          not null references UserInfo(UserNo) on delete cascade
    , writeDate 	date            default sysdate
    , content	    varchar2(2000)  not null
    , privateFlag	number          default 0
);
create sequence guestBook_Seq;

--방명록 댓글
create table GuestBookComment(
    guestBookComment_Seq	number          primary key
    , guestBook_seq	        number          not null references GuestBook(guestBook_Seq) on delete cascade
    , writerId	            number          not null references UserInfo(UserNo) on delete cascade
    , writeDate	            date            default sysdate
    , content	            Varchar2(500)   not null
    , parentSeq	            number          --references guestBookComment_Seq
    , rcvId	                number          references UserInfo(UserNo) on delete cascade --@id로 알릴경우 사용
);
create sequence guestBookComment_Seq;

--게시판 (판) & 공지사항
create table FreeBoard(
    board_Seq	    number          primary key
    , boardname	    varchar2(20)    not null        --게시판구분
    , writerId	    number          not null references UserInfo(UserNo) on delete cascade
    , writeDate 	date            default sysdate
    , title	        Varchar2(150)   not null
    , content	    varchar2(2000)
    , uploadFile	number          references FileMng(file_seq)
    , board_hits	number          default 0
);
create sequence board_Seq;

--게시판 댓글
create table FreeBoardComment(
    boardComments_Seq	number          primary key
    , board_Seq	        number          not null references FreeBoard(board_Seq) on delete cascade
    , writerId	        number          not null references UserInfo(UserNo) on delete cascade
    , writeDate     	date            default sysdate
    , content	        Varchar2(500)
    , parentSeq	        number
    , rcvId	            number          references UserInfo(UserNo) on delete cascade --@id로 알릴경우 사용
    , deleteFlag        number(1)		default 0 -- 삭제시 [일반게, 클럽게는 deleteFlag 체크해서 [삭제한 댓글입니다.]로 표시 
);
create sequence boardComments_Seq;

--클럽 리스트
create table ClubList(
    club_Seq	    number          primary key
    , clubName	    Varchar2(150)   not null
    , clubPhoto 	number          references FileMng(file_seq)
    , clubProfile	Varchar2(500)
);
create sequence club_Seq;

--클럽 게시판
create table ClubBoard(
    clubboard_Seq	    number          primary key
    , club_Seq	        number          not null references  ClubList(club_Seq)
    , clubboard_num	    number          not null
    , clubboard_name	Varchar2(50)    not null
    , writerId	        number          not null references UserInfo(UserNo) on delete cascade
    , writeDate     	date            default sysdate
    , title	            Varchar2(150)   not null
    , content	        varchar2(2000)
    , uploadFile	    number          references FileMng(file_seq)
    , board_hits	    number          default 0
);
create sequence clubboard_Seq;

--클럽 게시판 댓글
create table ClubBoardComment(
    clubboardComments_Seq	number          primary key
    , clubboard_Seq	        number          not null references ClubBoard(clubboard_Seq) on delete cascade
    , writerId  	        number          not null references UserInfo(UserNo) on delete cascade
    , writeDate           	date            default sysdate
    , content	            Varchar2(500)
    , parentSeq	            number
    , rcvId	                number          references UserInfo(UserNo) on delete cascade --@id로 알릴경우 사용
    , deleteFlag            number(1)		default 0 -- 삭제시 [일반게, 클럽게는 deleteFlag 체크해서 [삭제한 댓글입니다.]로 표시
);
create sequence clubboardComments_Seq;

--클럽 회원 목록
create table ClubMember(
    clubmember_Seq	    number          primary key
    , userId	        number          not null references UserInfo(UserNo) on delete cascade
    , club_Seq	        number          not null references ClubList(club_Seq) on delete cascade
    , clubmember_level	number(1)       default 1          -- 클럽내 등급
    , club_joindate	    date            default sysdate
);
create sequence clubmember_Seq;

--클럽 레벨에 대한 정보 ( 별칭 등 )
create table Clubmemberlevel(
    clubmemberlevel_Seq	    number          primary key
    , club_Seq	            number          not null references ClubList(club_Seq) on delete cascade        --어느클럽인지
    , clubmemberlevel   	number(1)       
    , clubmemberlevel_name	Varchar2(50)    not null            --별칭
);
create sequence clubmember_level_Seq;

-- 클럽 관리관련 레이아웃 설정메뉴
create table ClubLayout(
    club_Seq	number      not null references ClubList(club_Seq) on delete cascade
    , clubMgr_Layout	Number(1)
);