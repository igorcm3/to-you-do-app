import React from 'react';
import { StyledEntryCard } from './style';

function EntryCard({children}){
    return(
        <StyledEntryCard>
            {children}
        </StyledEntryCard>
    );
}

export default EntryCard;