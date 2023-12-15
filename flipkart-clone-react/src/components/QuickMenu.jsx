import { Box, Paper, Typography } from "@mui/material";

import React from "react";

const FocusAreaTiles = [
  {
    name: "Grocery",
    img: "img",
    idsDropdown: false,
  },
  {
    name: "Mobiles",
    img: "img",
    idsDropdown: false,
  },
  {
    name: "Fashion",
    img: "img",
    idsDropdown: true,
  },
  {
    name: "Electronics",
    img: "img",
    idsDropdown: true,
  },
  {
    name: "Home & Furniture",
    img: "img",
    idsDropdown: true,
  },
  {
    name: "Appliances",
    img: "img",
    idsDropdown: false,
  },
  {
    name: "Travel",
    img: "img",
    idsDropdown: false,
  },
  {
    name: "Beauty, Toys & More",
    img: "img",
    idsDropdown: true,
  },
  {
    name: "Two Wheelers",
    img: "img",
    idsDropdown: true,
  },
];
const classes = {
  tileRoot: { display: "flex", gap: 3, justifyContent: "space-between", m: 3 },
  tile: {
    width: "100%",
  },
};
const FocusArea = () => {
  return (
    <Paper elevation={2} sx={classes.tileRoot}>
      {FocusAreaTiles.map((tile, idx) => (
        <Box key={idx} sx={classes.tile}>
          <Typography>{tile.name}</Typography>
        </Box>
      ))}
    </Paper>
  );
};

export default FocusArea;
