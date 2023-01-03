import { FilmCard } from "./FilmCard"
import { useEffect, useState } from "react";
import { getAllFilms } from "./api/FilmApi";

export default function FilmList() {
	const [films, setFilms] = useState([]);

	useEffect(() => {
		getAllFilms().then(reponse => {
		setFilms(reponse.data);
		}).catch(err => {
		console.log(err);
		})
	}, []);


	return films.map((film)=> { return <FilmCard film={film} key={film.id} />})
}
