const initiaState = {
  id: '',
  user: null,
  isLoggedIn: false,
};

const auth = (state = initiaState, action) => {
  switch (action.type) {
    case 'AUTH_SET':
      return {
        id: action.id,
        user: action.user,
        isLoggedIn: true,
      };
    case 'AUTH_UNSET':
      return {
        id: '',
        user: null,
        isLoggedIn: false,
      };
    default:
      return state;
  }
};

export default auth;
