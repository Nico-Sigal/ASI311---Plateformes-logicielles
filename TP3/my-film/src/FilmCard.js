import { Card, CardContent, Typography } from "../node_modules/@mui/material/index";

export function FilmCard(props) {
return (
      <Card variant="outlined">
      <CardContent>
                  <Typography variant="h5" gutterBottom>
                        {props.film.titre}
                  </Typography>
                  <Typography variant="body1">
                              {props.film.duree} minutes
                  </Typography>
            </CardContent>
</Card>
)
}