export const AUTH = "/api/auth";

export function saveAuth({ token, role }) {
  localStorage.setItem("token", token);
  localStorage.setItem("role", role);
}

export function getAuth() {
  return {
    token: localStorage.getItem("token"),
    role: localStorage.getItem("role")
  };
}

export function logout() {
  localStorage.clear();
  window.location.href = "/";
}

export function goByRole(role) {
  switch (role) {
    case "STUDENT": window.location.href = "/student/dashboard.html"; break;
    case "EMPLOYER": window.location.href = "/employer/dashboard.html"; break;
    case "UNIVERSITY": window.location.href = "/university/dashboard.html"; break;
    default: logout();
  }
}
