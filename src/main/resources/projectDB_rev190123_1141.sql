-- ���̺� ����
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

-- ������ ����
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


-- ���̺� ����
--�������� ���̺�
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

--���� ���� ���̺�
create table FileMng(
    file_seq	    number          primary key
    , originalName	varchar2(200)   not null
    , saveName	    varchar2(200)   not null
    , path	        varchar2(500)   not null
);
create SEQUENCE file_seq;

--ģ��(����) ���̺�
create table UserFriends(
    UserFriends_Seq	number          primary key
    , UserOwner 	number    references UserInfo(UserNo) on delete cascade
    , UserFriend	number    references UserInfo(UserNo) on delete cascade
    , FriendNick	Varchar2(30)    
);
create SEQUENCE UserFriends_Seq;

--�̴�Ȩ�� ����
create table MiniHomeMain( 
    miniH_Seq	    number          primary key
    , userId	    number          not null references UserInfo(UserNo) on delete cascade
    , userPhoto	    number          not null references FileMng(file_seq)
    , userProfile	Varchar2(200)
    , miniHits	    number          default 0
    , privateFlag	Number(1)       default 0
);
create sequence miniH_Seq;

--�̴�Ȩ�� �湮��üũ (daily unique) & �ֱٹ湮�� ���Ȯ�ο�
create table MiniHits(
    miniHits_Seq	number          primary key
    , userId	    number          not null references UserInfo(UserNo) on delete cascade
    , visitorId	    number          not null references UserInfo(UserNo) on delete cascade
    , dateLogger	date            default sysdate
);
create sequence miniHits_Seq;

--����
create table GuestBook(
    guestBook_Seq	number          primary key
    , userId	    number          not null references UserInfo(UserNo) on delete cascade
    , writerId	    number          not null references UserInfo(UserNo) on delete cascade
    , writeDate 	date            default sysdate
    , content	    varchar2(2000)  not null
    , privateFlag	number          default 0
);
create sequence guestBook_Seq;

--���� ���
create table GuestBookComment(
    guestBookComment_Seq	number          primary key
    , guestBook_seq	        number          not null references GuestBook(guestBook_Seq) on delete cascade
    , writerId	            number          not null references UserInfo(UserNo) on delete cascade
    , writeDate	            date            default sysdate
    , content	            Varchar2(500)   not null
    , parentSeq	            number          --references guestBookComment_Seq
    , rcvId	                number          references UserInfo(UserNo) on delete cascade --@id�� �˸���� ���
);
create sequence guestBookComment_Seq;

--�Խ��� (��) & ��������
create table FreeBoard(
    board_Seq	    number          primary key
    , boardname	    varchar2(20)    not null        --�Խ��Ǳ���
    , writerId	    number          not null references UserInfo(UserNo) on delete cascade
    , writeDate 	date            default sysdate
    , title	        Varchar2(150)   not null
    , content	    varchar2(2000)
    , uploadFile	number          references FileMng(file_seq)
    , board_hits	number          default 0
);
create sequence board_Seq;

--�Խ��� ���
create table FreeBoardComment(
    boardComments_Seq	number          primary key
    , board_Seq	        number          not null references FreeBoard(board_Seq) on delete cascade
    , writerId	        number          not null references UserInfo(UserNo) on delete cascade
    , writeDate     	date            default sysdate
    , content	        Varchar2(500)
    , parentSeq	        number
    , rcvId	            number          references UserInfo(UserNo) on delete cascade --@id�� �˸���� ���
    , deleteFlag        number(1)		default 0 -- ������ [�Ϲݰ�, Ŭ���Դ� deleteFlag üũ�ؼ� [������ ����Դϴ�.]�� ǥ�� 
);
create sequence boardComments_Seq;

--Ŭ�� ����Ʈ
create table ClubList(
    club_Seq	    number          primary key
    , clubName	    Varchar2(150)   not null
    , clubPhoto 	number          references FileMng(file_seq)
    , clubProfile	Varchar2(500)
);
create sequence club_Seq;

--Ŭ�� �Խ���
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

--Ŭ�� �Խ��� ���
create table ClubBoardComment(
    clubboardComments_Seq	number          primary key
    , clubboard_Seq	        number          not null references ClubBoard(clubboard_Seq) on delete cascade
    , writerId  	        number          not null references UserInfo(UserNo) on delete cascade
    , writeDate           	date            default sysdate
    , content	            Varchar2(500)
    , parentSeq	            number
    , rcvId	                number          references UserInfo(UserNo) on delete cascade --@id�� �˸���� ���
    , deleteFlag            number(1)		default 0 -- ������ [�Ϲݰ�, Ŭ���Դ� deleteFlag üũ�ؼ� [������ ����Դϴ�.]�� ǥ��
);
create sequence clubboardComments_Seq;

--Ŭ�� ȸ�� ���
create table ClubMember(
    clubmember_Seq	    number          primary key
    , userId	        number          not null references UserInfo(UserNo) on delete cascade
    , club_Seq	        number          not null references ClubList(club_Seq) on delete cascade
    , clubmember_level	number(1)       default 1          -- Ŭ���� ���
    , club_joindate	    date            default sysdate
);
create sequence clubmember_Seq;

--Ŭ�� ������ ���� ���� ( ��Ī �� )
create table Clubmemberlevel(
    clubmemberlevel_Seq	    number          primary key
    , club_Seq	            number          not null references ClubList(club_Seq) on delete cascade        --���Ŭ������
    , clubmemberlevel   	number(1)       
    , clubmemberlevel_name	Varchar2(50)    not null            --��Ī
);
create sequence clubmember_level_Seq;

-- Ŭ�� �������� ���̾ƿ� �����޴�
create table ClubLayout(
    club_Seq	number      not null references ClubList(club_Seq) on delete cascade
    , clubMgr_Layout	Number(1)
);