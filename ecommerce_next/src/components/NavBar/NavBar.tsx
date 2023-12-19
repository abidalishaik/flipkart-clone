"use client";

import { Box, Paper, Typography } from "@mui/material";
import React, { useState } from "react";

import HomeIcon from "@mui/icons-material/Home";
import Link from "next/link";
import TextFieldComponent from "@/elements/TextFieldComponent";

const classes = {
  root: {
    height: 60,
  },
  container: {
    mx: 3,
    display: "flex",
    height: 60,
    justifyContent: "space-between",
    alignItems: "center",
  },
};

const NavBar = () => {
  const [globalSearchValue, setGlobalSearchValue] = useState<string>("");
  function headerSearch(e: any) {
    setGlobalSearchValue(e.target.value);
  }

  return (
    <Box component={"nav"} sx={classes.root}>
      <Paper>
        <Box sx={classes.container}>
          <Link
            href={"/Home"}
            style={{ display: "flex", alignItems: "center" }}
          >
            <HomeIcon fontSize="medium" />
            <Typography variant="h5">Home</Typography>
          </Link>
          <Box sx={{ width: 650 }}>
            <TextFieldComponent
              onChange={(e: any) => headerSearch(e)}
              value={globalSearchValue}
              size="small"
              label="Search"
              variant="filled"
            />
          </Box>
          <Link href={"/About"}>
            <Typography variant="h5">About</Typography>
          </Link>
          <Link href={"/Contact"}>
            <Typography variant="h5">Contact</Typography>
          </Link>
        </Box>
      </Paper>
    </Box>
  );
};

export default NavBar;
