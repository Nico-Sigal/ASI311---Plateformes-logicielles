import { AppBar, Toolbar, Typography } from "../node_modules/@mui/material/index";

export default function Header() {
return( <AppBar position="static">
<Toolbar>
  <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
	  My Films
  </Typography>
</Toolbar>
</AppBar>
)
}