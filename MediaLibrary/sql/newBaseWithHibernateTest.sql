--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Album; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Album" (
    "ID" bigint NOT NULL,
    album_name character varying(80) NOT NULL,
    album_publisher character varying(80) NOT NULL,
    year_of_publishing integer NOT NULL,
    "artist_ID" bigint NOT NULL
);


ALTER TABLE "Album" OWNER TO postgres;

--
-- Name: Album_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Album_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Album_ID_seq" OWNER TO postgres;

--
-- Name: Album_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Album_ID_seq" OWNED BY "Album"."ID";


--
-- Name: Artist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Artist" (
    "ID" bigint NOT NULL,
    first_name character varying(80) NOT NULL,
    last_name character varying(80) NOT NULL,
    artist_name character varying(80)
);


ALTER TABLE "Artist" OWNER TO postgres;

--
-- Name: Artist_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Artist_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Artist_ID_seq" OWNER TO postgres;

--
-- Name: Artist_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Artist_ID_seq" OWNED BY "Artist"."ID";


--
-- Name: Song; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Song" (
    "ID" bigint NOT NULL,
    title character varying(80) NOT NULL,
    duration double precision NOT NULL,
    song_writer character varying(80),
    genre character varying(80) NOT NULL,
    "artist_ID" bigint NOT NULL,
    "album_ID" bigint NOT NULL
);


ALTER TABLE "Song" OWNER TO postgres;

--
-- Name: Song_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Song_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Song_ID_seq" OWNER TO postgres;

--
-- Name: Song_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Song_ID_seq" OWNED BY "Song"."ID";


--
-- Name: Album ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Album" ALTER COLUMN "ID" SET DEFAULT nextval('"Album_ID_seq"'::regclass);


--
-- Name: Artist ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Artist" ALTER COLUMN "ID" SET DEFAULT nextval('"Artist_ID_seq"'::regclass);


--
-- Name: Song ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Song" ALTER COLUMN "ID" SET DEFAULT nextval('"Song_ID_seq"'::regclass);


--
-- Data for Name: Album; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Album" ("ID", album_name, album_publisher, year_of_publishing, "artist_ID") FROM stdin;
20	Acoustic Live in Newcastle 	The Soul Cages	1991	1
21	Acoustic Live in Newcastle 	The Soul Cages	1991	1
23	Acoustic Live in Newcastle 	The Soul Cages	1991	1
25	Acoustic Live in Newcastle 	The Soul Cages	1991	1
26	Acoustic Live in Newcastle 	The Soul Cages	1991	1
27	Acoustic Live in Newcastle 	The Soul Cages	1991	1
22	Some new album name!	The Soul Cages	1991	1
\.


--
-- Name: Album_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Album_ID_seq"', 27, true);


--
-- Data for Name: Artist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Artist" ("ID", first_name, last_name, artist_name) FROM stdin;
1	Gordon Matthew Thomas	Sumner	String
9	Gordon Matthew Thomas	Sumner	String
10	Gordon Matthew Thomas	Sumner	String
11	Gordon Matthew Thomas	Sumner	String
12	Gordon Matthew Thomas	Sumner	String
13	Gordon Matthew Thomas	Sumner	String
17	Gordon Matthew Thomas	Sumner	String
29	Gordon Matthew Thomas	Sumner	String
31	Gordon Matthew Thomas	Sumner	String
32	Gordon Matthew Thomas	Sumner	String
34	Gordon Matthew Thomas	Sumner	String
36	Gordon Matthew Thomas	Sumner	String
37	Gordon Matthew Thomas	Sumner	String
38	Gordon Matthew Thomas	Sumner	String
30	Gordon Matthew Thomas	Sumner	Some new artist name!
35	Gordon Matthew Thomas	Sumner	Some new artist name!
\.


--
-- Name: Artist_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Artist_ID_seq"', 38, true);


--
-- Data for Name: Song; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Song" ("ID", title, duration, song_writer, genre, "artist_ID", "album_ID") FROM stdin;
11	Mad About You	3.1400000000000001	Sting	Jazz,Pop	1	20
12	Mad About You	3.1400000000000001	Sting	Jazz,Pop	1	21
14	Mad About You	3.1400000000000001	Sting	Jazz,Pop	1	21
13	Mad About You	3.1400000000000001	Some new song writer name!	Jazz,Pop	1	21
\.


--
-- Name: Song_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Song_ID_seq"', 14, true);


--
-- Name: Album Album_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Album"
    ADD CONSTRAINT "Album_pkey" PRIMARY KEY ("ID");


--
-- Name: Artist Artist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Artist"
    ADD CONSTRAINT "Artist_pkey" PRIMARY KEY ("ID");


--
-- Name: Song Song_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Song"
    ADD CONSTRAINT "Song_pkey" PRIMARY KEY ("ID");


--
-- Name: Song album_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Song"
    ADD CONSTRAINT album_fkey FOREIGN KEY ("album_ID") REFERENCES "Album"("ID");


--
-- Name: Album artist_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Album"
    ADD CONSTRAINT artist_fkey FOREIGN KEY ("artist_ID") REFERENCES "Artist"("ID");


--
-- Name: Song artist_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Song"
    ADD CONSTRAINT artist_fkey FOREIGN KEY ("artist_ID") REFERENCES "Artist"("ID");


--
-- PostgreSQL database dump complete
--

