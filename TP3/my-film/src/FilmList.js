import { FilmCard } from "./FilmCard"
import { mockFilms } from "./mock/FilmMock"

export default function FilmList() {
	const films= mockFilms

	return films.map((film)=> { return <FilmCard film={film} key={film.id} />})
}
