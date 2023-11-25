import * as React from "react";

import { alpha, styled } from "@mui/material/styles";

import AccountCircle from "@mui/icons-material/AccountCircle";
import AccountCircleOutlinedIcon from "@mui/icons-material/AccountCircleOutlined";
import AppBar from "@mui/material/AppBar";
import Badge from "@mui/material/Badge";
import Box from "@mui/material/Box";
import IconButton from "@mui/material/IconButton";
import InputBase from "@mui/material/InputBase";
import LoginMenu from "./LoginMenu";
import MailIcon from "@mui/icons-material/Mail";
import Menu from "@mui/material/Menu";
import MenuIcon from "@mui/icons-material/Menu";
import MenuItem from "@mui/material/MenuItem";
import MoreIcon from "@mui/icons-material/MoreVert";
import NotificationsIcon from "@mui/icons-material/Notifications";
import SearchIcon from "@mui/icons-material/Search";
import ShoppingCartOutlinedIcon from "@mui/icons-material/ShoppingCartOutlined";
import StorefrontOutlinedIcon from "@mui/icons-material/StorefrontOutlined";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";

const Search = styled("div")(({ theme }) => ({
  position: "relative",
  borderRadius: theme.shape.borderRadius,
  backgroundColor: "#F0F5FF",
  marginRight: theme.spacing(2),
  marginLeft: 0,
  width: "100%",
  [theme.breakpoints.up("sm")]: {
    marginLeft: theme.spacing(3),
    width: "auto",
  },
}));

const SearchIconWrapper = styled("div")(({ theme }) => ({
  padding: theme.spacing(0, 2),
  height: "100%",
  position: "absolute",
  pointerEvents: "none",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: "inherit",
  "& .MuiInputBase-input": {
    color: "#8E6666",
    padding: theme.spacing(1, 1, 1, 0),
    // vertical padding + font size from searchIcon
    paddingLeft: `calc(1em + ${theme.spacing(4)})`,
    transition: theme.transitions.create("width"),
    width: "100%",
    cursor: "pointer",
    [theme.breakpoints.up("md")]: {
      width: "100ch",
    },
  },
}));

export default function NavBar() {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const [mobileMoreAnchorEl, setMobileMoreAnchorEl] = React.useState(null);

  const isMenuOpen = Boolean(anchorEl);
  const isMobileMenuOpen = Boolean(mobileMoreAnchorEl);

  const handleProfileMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMobileMenuClose = () => {
    setMobileMoreAnchorEl(null);
  };

  const handleMenuClose = () => {
    setAnchorEl(null);
    handleMobileMenuClose();
  };

  const handleMobileMenuOpen = (event) => {
    setMobileMoreAnchorEl(event.currentTarget);
  };

  const menuId = "primary-search-account-menu";
  const renderMenu = (
    <Menu
      anchorEl={anchorEl}
      anchorOrigin={{
        vertical: "top",
        horizontal: "right",
      }}
      id={menuId}
      keepMounted
      transformOrigin={{
        vertical: "top",
        horizontal: "right",
      }}
      open={isMenuOpen}
      onClose={handleMenuClose}
    >
      <MenuItem onClick={handleMenuClose}>Profile</MenuItem>
      <MenuItem onClick={handleMenuClose}>My account</MenuItem>
    </Menu>
  );

  const mobileMenuId = "primary-search-account-menu-mobile";
  const renderMobileMenu = (
    <Menu
      anchorEl={mobileMoreAnchorEl}
      anchorOrigin={{
        vertical: "top",
        horizontal: "right",
      }}
      id={mobileMenuId}
      keepMounted
      transformOrigin={{
        vertical: "top",
        horizontal: "right",
      }}
      open={isMobileMenuOpen}
      onClose={handleMobileMenuClose}
    >
      <MenuItem>
        <IconButton size="large" aria-label="show 4 new mails" color="inherit">
          <Badge badgeContent={4} color="error">
            <MailIcon />
          </Badge>
        </IconButton>
        <p>Messages</p>
      </MenuItem>
      <MenuItem>
        <IconButton
          size="large"
          aria-label="show 17 new notifications"
          color="inherit"
        >
          <Badge badgeContent={17} color="error">
            <NotificationsIcon />
          </Badge>
        </IconButton>
        <p>Notifications</p>
      </MenuItem>
      <MenuItem onClick={handleProfileMenuOpen}>
        <IconButton
          size="large"
          aria-label="account of current user"
          aria-controls="primary-search-account-menu"
          aria-haspopup="true"
          color="inherit"
        >
          <AccountCircle />
        </IconButton>
        <p>Profile</p>
      </MenuItem>
    </Menu>
  );

  return (
    <Box>
      <AppBar position="static" sx={{ background: "#FFFFFF" }}>
        <Toolbar sx={{ p: "0px 30px" }}>
          {/* left title */}
          <Box
            variant="h6"
            noWrap
            component="div"
            sx={{ display: { xs: "none", sm: "block" }, width: "10%" }}
          >
            <Typography
              variant="h5"
              sx={{ fontStyle: "italic", pb: 0, color: "#1976D2" }}
              fontWeight={"bold"}
            >
              Flipkart
            </Typography>
            <Box
              sx={{
                mt: 0,
                display: "flex",
                gap: 0.4,
                justifyContent: "center",
              }}
            >
              <Typography
                variant="caption"
                fontWeight={"bold"}
                sx={{ fontStyle: "italic", fontSize: "12px", color: "#9E9E9E" }}
              >
                Explore
              </Typography>
              <Typography
                variant="caption"
                fontWeight={"bold"}
                sx={{ fontStyle: "italic", fontSize: "12px", color: "#FFCA22" }}
              >
                plus
              </Typography>
            </Box>
          </Box>
          {/* global search */}
          <Box sx={{ width: "50%" }}>
            <Search>
              <SearchIconWrapper>
                <SearchIcon sx={{ color: "#8E6666" }} />
              </SearchIconWrapper>
              <StyledInputBase
                placeholder="Search for products, Brands and More"
                inputProps={{ "aria-label": "search" }}
              />
            </Search>
          </Box>
          {/* rihgt side menus */}
          <Box
            sx={{
              display: { xs: "none", md: "flex" },
              justifyContent: "space-evenly",
              width: "40%",
            }}
          >
            <IconButton size="large" color="inherit">
              <LoginMenu />
              {/* <AccountCircleOutlinedIcon sx={{ color: "#8E6666" }} />
              <Typography variant="body1" sx={{ pl: 1, color: "#8E6666" }}>
                Login
              </Typography> */}
            </IconButton>
            <IconButton size="large" color="inherit">
              <ShoppingCartOutlinedIcon sx={{ color: "#8E6666" }} />
              <Typography variant="body1" sx={{ pl: 1, color: "#8E6666" }}>
                Cart
              </Typography>
            </IconButton>
            <IconButton size="large" color="inherit">
              <StorefrontOutlinedIcon sx={{ color: "#8E6666" }} />
              <Typography variant="body1" sx={{ pl: 1, color: "#8E6666" }}>
                Become a Seller
              </Typography>
            </IconButton>
            <IconButton size="large" color="inherit">
              <MoreIcon sx={{ color: "#8E6666" }} />
            </IconButton>
          </Box>
        </Toolbar>
      </AppBar>
      {renderMobileMenu}
      {renderMenu}
    </Box>
  );
}
