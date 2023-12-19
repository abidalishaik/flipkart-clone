"use client";

import { Box } from "@mui/material";
import React from "react";
import TextField from "@mui/material/TextField";

const classes = {
  primary: {
    "& .MuiFormControl-root": {
      width: "100%",
    },
  },
};

const TextFieldComponent = (props: any) => {
  const { size, label, variant, onChange, value } = props;

  function handleChange(e: any) {
    if (onChange) {
      onChange(e);
    }
  }
  return (
    <Box sx={classes.primary}>
      <TextField
        value={value}
        onChange={handleChange}
        size={size}
        id="outlined-basic"
        label={label}
        variant={variant}
      />
    </Box>
  );
};

export default TextFieldComponent;
